package com.sisint.generador.handler;

import com.palominolabs.http.url.UrlBuilder;

import com.sisint.common.exceptions.BusinessException;
import com.sisint.common.resources.ws.FailResponse;
import com.sisint.common.resources.ws.RestResponse;
import com.sisint.fakturama.models.FktDocument;
import com.sisint.fakturama.repository.FktDocumentRepository;
import com.sisint.generador.resources.GeneradorResource;
import play.Logger;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;


//import v1.post.PostResource;

import javax.inject.Inject;
import java.nio.charset.CharacterCodingException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * Handles presentation of Post resources, which map to JSON.
 */
public class GeneradorHandler {
    private final Logger.ALogger logger = play.Logger.of("application.GeneradorHandler");

    //private final PostRepository repository;
    private final FktDocumentRepository repository;
    private final HttpExecutionContext ec;

    @Inject
    public GeneradorHandler(FktDocumentRepository repository, HttpExecutionContext ec) {
    //public GeneradorHandler(PostRepository repository, HttpExecutionContext ec) {
        this.repository = repository;
        this.ec = ec;
    }
/*
    public CompletionStage<Stream<PostResource>> find() {
        return repository.list().thenApplyAsync(postDataStream -> {
            return postDataStream.map(data -> new PostResource(data, link(data)));
        }, ec.current());
    }
*/

    public CompletionStage<Optional<RestResponse>> generarArchivo(GeneradorResource resource) throws BusinessException {
        if (logger.isDebugEnabled()) {
            logger.debug("generarArchivo() resource = " + resource);
            logger.debug("generarArchivo() resource.getTipoOperacion = " + resource.getTipoOperacion());
            logger.debug("generarArchivo() resource.getDocumentoTipo = " + resource.getDocumentoTipo());
            logger.debug("generarArchivo() resource.getEquivalenciaDocumentoTipo = " + resource.getEquivalenciaDocumentoTipo());
            logger.debug("generarArchivo() resource.getEquivalenciaTipoOperacion = " + resource.getEquivalenciaTipoOperacion());
        }

        try {
            validarDatosEntrada(resource);

            return repository.getByNumber(resource).thenApplyAsync(optionalData -> {
                try {
                    validarDatosDocumento(optionalData.get());
                } catch (BusinessException e) {
                    return Optional.of(new RestResponse(new FailResponse("01", e.getMessage())));
                }
                return optionalData.map(data ->
                        new RestResponse(new GeneradorResource(data, link(data)))
                );
            }, ec.current());
        } catch (BusinessException e) {
            return CompletableFuture.completedFuture(Optional.of(new RestResponse(new FailResponse("01", e.getMessage()))));
        }
    }

    private void validarDatosEntrada(GeneradorResource resource) throws BusinessException {
        String tipoDocumento = resource.getEquivalenciaDocumentoTipo();
        String tipoOperacion = resource.getEquivalenciaTipoOperacion();
        if(tipoDocumento != null && (tipoDocumento.equals("Invoice") || tipoDocumento.equals("Proforma") || tipoDocumento.equals("Credit"))){
        } else {
            throw new BusinessException("No es una Factura o Boleta o Nota de Credito");
        }
        if(tipoOperacion != null &&( tipoOperacion.equals("01") || tipoOperacion.equals("02") )){
        } else {
            throw new BusinessException("La operación debe ser una ALTA o BAJA");
        }
        if(resource.getEmisorRuc() == null || resource.getEmisorRuc().isEmpty()){
            throw new BusinessException("No se ingreso el RUC del emisor.");
        }
        //return;
    }

    private void validarDatosDocumento(FktDocument documento) throws BusinessException {
        if((null == documento.items ) || 0 == documento.items.size()) {
            //System.err.println("EL DOCUMENTO NO TIENE ITEMS");
            throw new BusinessException("El documento no tiene items");
        } else if (null == documento.contact || null == documento.contact.getVATNUMBER() ){
            //System.err.println("EL DOCUMENTO NO TIENE CONTACTO");
            throw new BusinessException("El documento no tiene contacto");
        }
    }

    /*
        public CompletionStage<Optional<PostResource>> lookup(String id) {
            return repository.get(Long.parseLong(id)).thenApplyAsync(optionalData -> {
                return optionalData.map(data -> new PostResource(data, link(data)));
            }, ec.current());
        }
    
        public CompletionStage<Optional<PostResource>> update(String id, PostResource resource) {
            final PostData data = new PostData(resource.getTitle(), resource.getBody());
            return repository.update(Long.parseLong(id), data).thenApplyAsync(optionalData -> {
                return optionalData.map(op -> new PostResource(op, link(op)));
            }, ec.current());
        }
    */

    private String link(FktDocument data) {
        // Make a point of using request context here, even if it's a bit strange
        final Http.Request request = Http.Context.current().request();
        final String[] hostPort = request.host().split(":");
        String host = hostPort[0];
        int port = (hostPort.length == 2) ? Integer.parseInt(hostPort[1]) : -1;
        final String scheme = request.secure() ? "https" : "http";
        try {
            return UrlBuilder.forHost(scheme, host, port)
                    .pathSegments("generarArchivo",  data.NAME)
                    .toUrlString();
        } catch (CharacterCodingException e) {
            throw new IllegalStateException(e);
        }
    }
}
