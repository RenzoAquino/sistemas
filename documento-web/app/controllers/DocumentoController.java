package controllers;

import commons.util.ticket.GenerarTicketDetallado;
import commons.util.ticket.GenerarTicketResumido;
import commons.util.ImpresoraUtil;
import commons.util.PDFUtil;
import controllers.dto.DocumentoDTO;
import models.Documento;
import models.fakturama.FktDocument;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import services.DocumentoService;
import views.html.documento.*;
import views.html.errors.*;

import javax.inject.Inject;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DocumentoController extends Controller{

    @Inject
    FormFactory formFactory;

    // para todos los documentos
    public Result index(){
        //Set<Documento> documentos = Documento.obtenerTodos();
        List<Documento> documentos = Documento.find.all();//obtenerTodos();
        return ok(index.render(documentos));
    }

    // para crear
    public Result crear(){
        Form<Documento> documentoForm = formFactory.form(Documento.class);
        return ok(crear.render(documentoForm));
    }

    // para guardar
    public Result guardar(){
        Form<Documento> documentoForm = formFactory.form(Documento.class).bindFromRequest();
        if(documentoForm.hasErrors()){
            flash("danger","Por favor corregir los errores del formulario");
            return badRequest(crear.render(documentoForm));
        }

        Documento documento = documentoForm.get();
        documento.save();
        flash("success","Se creo correctamente el documento.");
        //Documento.guardar(documento);

        return redirect(routes.DocumentoController.index());
    }
    public Result editar(Long id){
        Documento documento = Documento.find.byId(id);//Documento.buscarPorId(id);
        if(documento==null)
            return notFound(_404.render());

        Form<Documento> documentoForm = formFactory.form(Documento.class).fill(documento);

        return ok(editar.render(documentoForm));
    }
    public Result actualizar(){

        Form<Documento> documentoForm = formFactory.form(Documento.class).bindFromRequest();
        if(documentoForm.hasErrors()){
            flash("danger","Por favor corregir los errores del formulario");
            return badRequest(editar.render(documentoForm));
        }

        Documento documento = documentoForm.get();
        Documento oldDocumento = Documento.find.byId(documento.id);
        if(oldDocumento==null) {
            flash("danger", "Documento no encontrado");
            return notFound();
        }
        oldDocumento.name = documento.name;
        oldDocumento.typeDocumento = documento.typeDocumento;
        oldDocumento.igv = documento.igv;
        oldDocumento.menssage1 = documento.menssage1;
        oldDocumento.menssage2 = documento.menssage2;
        oldDocumento.menssage3 = documento.menssage3;
        oldDocumento.update();

        flash("success","Se actualizo correctamente el documento.");

        return ok();
        //return redirect(routes.DocumentoController.index());
    }
    public Result eliminar(Long id){
        Documento documento = Documento.find.byId(id);
        if(documento==null) {
            flash("danger", "Documento no encontrado");
            return notFound();
        }
        documento.delete();//Documento.eliminar(documento);

        flash("success","Se elimino correctamente el documento.");

        return ok();//redirect(routes.DocumentoController.index());
    }

    // para el detalle
    public Result ver(Long id){
        Documento documento = Documento.find.byId(id);
        if(documento == null)
            return notFound(_404.render());

        return ok(ver.render(documento));
    }

    public Result verImprimirTicket(){

        DocumentoDTO dto = new DocumentoDTO();
        dto.tipoDetalle ="R";
        dto.listaTipoAccion = new ArrayList<String>();
        dto.listaTipoAccion.add("IMP");

        Form<DocumentoDTO> documentoDTOForm = formFactory.form(DocumentoDTO.class).fill(dto);

        return ok(verImprimirTicket.render(documentoDTOForm));
    }

    // para generarTicket
    public Result imprimirTicket() throws Exception {
        Form<DocumentoDTO> documentoDTOForm = formFactory.form(DocumentoDTO.class).bindFromRequest();
        if(documentoDTOForm.hasErrors()){
            flash("danger","Por favor corregir los errores del formulario");
            return badRequest(verImprimirTicket.render(documentoDTOForm));
        }

        if(documentoDTOForm.get().listaTipoAccion == null){
            flash("danger","Por favor seleccionar si va imprimir y/o generar un pdf");
            return badRequest(verImprimirTicket.render(documentoDTOForm));
        }

        DocumentoDTO dto = documentoDTOForm.get();
        System.out.println(dto);
        FktDocument document = DocumentoService.obtenerDatosDocumento(dto);
        System.out.println(document);

        GenerarTicketResumido impR= new GenerarTicketResumido(document);
        GenerarTicketDetallado impD = new GenerarTicketDetallado(document);

        try {
            if(dto.tipoDetalle.equals("D")){
                impD.generarTicket();
            }
            else if(dto.tipoDetalle.equals("R")){
                impR.generarTicket();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ejecutarTipoAccion(dto.listaTipoAccion,document);



/*
        FktContact fktContact = FktContact.find.byId(document.contact.ID);
        System.out.println(fktContact);
*/
/*
        List<FktDocumentitem> items = FktDocumentitem.find.query()
                .fetch("vat")
                .where()
                .eq("fk_document",document.ID)
                .findList();
        for (FktDocumentitem item: items
             ) {
            System.out.println(item);
        }
*/

        //documentoDTO.generarTicket();

        flash("success","Se realizo correctamente la operación.");

        //return redirect(routes.DocumentoController.verImprimirTicket());
        return ok(verImprimirTicket.render(documentoDTOForm));
    }

    private void ejecutarTipoAccion(List<String> listaTipoAccion,FktDocument document) throws InterruptedException, PrinterException, IOException {
        for (String string: listaTipoAccion) {
            System.out.println(string);
            if(string.equals("IMP")) {
                ImpresoraUtil.enviarAImpresora();
            } else if(string.equals("PDF")) {
                PDFUtil.convertirTXTaPDF(document.NAME+"_"+document.contact.COMPANY+".pdf");
            }
        }
    }
}
