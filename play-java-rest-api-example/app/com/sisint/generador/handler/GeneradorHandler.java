package com.sisint.generador.handler;

import com.palominolabs.http.url.UrlBuilder;
import com.sisint.common.util.ConvertUtil;
import com.sisint.fakturama.handler.FakturamaHandler;
import com.sisint.generador.resources.GeneradorResource;
//import jdk.nashorn.internal.parser.JSONParser;
import com.sisint.sfs.handler.SFSHandler;
import play.Logger;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;
//import scala.util.parsing.json.JSONArray;
//import scala.util.parsing.json.JSONObject;
import v1.post.PostData;
import v1.post.PostRepository;
import v1.post.PostResource;

import javax.inject.Inject;
import java.io.*;
import java.nio.charset.CharacterCodingException;
import java.util.Optional;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * Handles presentation of Post resources, which map to JSON.
 */
public class GeneradorHandler {
    private final Logger.ALogger logger = play.Logger.of("application.GeneradorHandler");


    private final PostRepository repository;
    private final HttpExecutionContext ec;

    @Inject
    public GeneradorHandler(PostRepository repository, HttpExecutionContext ec) {
        this.repository = repository;
        this.ec = ec;
    }

    public CompletionStage<Stream<PostResource>> find() {
        return repository.list().thenApplyAsync(postDataStream -> {
            return postDataStream.map(data -> new PostResource(data, link(data)));
        }, ec.current());
    }

    public CompletionStage<PostResource> generarArchivo(GeneradorResource resource) throws IOException {
        if (logger.isDebugEnabled()) {
            logger.debug("generarArchivo() resource = " + resource);
        }

        //SFSHandler.obtenerListaOperacion().forEach(System.out::println);
        //ConvertUtil.convertListMapaToMap(SFSHandler.obtenerListaOperacion()).forEach(System.out::println);
        //System.out.println(ConvertUtil.convertListMapaToMap(SFSHandler.obtenerListaOperacion()));
        //System.out.println(ConvertUtil.convertListMapaToMap(FakturamaHandler.obtenerListaTipoDocumento()));

        if (logger.isDebugEnabled()) {
            logger.debug("generarArchivo() resource.getTipoOperacion = " + resource.getTipoOperacion());
            logger.debug("generarArchivo() resource.getDocumentoTipo = " + resource.getDocumentoTipo());
        }



        PostResource resource01 = new PostResource();
        final PostData data = new PostData(resource01.getTitle(), resource01.getBody());
        return repository.create(data).thenApplyAsync(savedData -> {
            return new PostResource(savedData, link(savedData));
        }, ec.current());
    }

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

    private String link(PostData data) {
        // Make a point of using request context here, even if it's a bit strange
        final Http.Request request = Http.Context.current().request();
        final String[] hostPort = request.host().split(":");
        String host = hostPort[0];
        int port = (hostPort.length == 2) ? Integer.parseInt(hostPort[1]) : -1;
        final String scheme = request.secure() ? "https" : "http";
        try {
            return UrlBuilder.forHost(scheme, host, port)
                    .pathSegments("v1", "posts", data.id.toString())
                    .toUrlString();
        } catch (CharacterCodingException e) {
            throw new IllegalStateException(e);
        }
    }
}
