package controllers;

import commons.TypeDocument_ES;
import controllers.dto.DocumentoDTO;
import io.ebean.Ebean;
import io.ebean.Query;
import models.Documento;
import models.fakturama.FktContact;
import models.fakturama.FktDocument;
import models.fakturama.FktDocumentitem;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.documento.*;
import views.html.errors.*;

import javax.inject.Inject;
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
        Form<DocumentoDTO> documentoDTOForm = formFactory.form(DocumentoDTO.class);
        return ok(verImprimirTicket.render(documentoDTOForm));
    }

    // para imprimir
    public Result imprimirTicket(){
        Form<DocumentoDTO> documentoDTOForm = formFactory.form(DocumentoDTO.class).bindFromRequest();
        if(documentoDTOForm.hasErrors()){
            flash("danger","Por favor corregir los errores del formulario");
            return badRequest(verImprimirTicket.render(documentoDTOForm));
        }




        DocumentoDTO dto = documentoDTOForm.get();
        System.out.println(dto);
        FktDocument document = null;
/*
        FktContact contact = FktContact.find.query().where().eq("vatnumber",dto.rucEmpresa).findOne();
        System.out.println(contact);
*/
/*
        document =
                Ebean.find(FktDocument.class)
                        .where().eq("name",document.NAME)
                        .findOne();
*/
        //Buscar Documento
        document = FktDocument.find.query()
                //.fetch("contact" ).alias("c")
                //.fetch("fktdocumentitem")
                //.fetch("fktdocumentitem.vat")
                .where()
                .eq("name",dto.numero)
                .eq("dtype",TypeDocument_ES.valueOf(dto.tipoDocumento).getText())
                .findOne();
        document.contact = FktContact.find.byId(document.contact.ID);

        document.items = FktDocumentitem.find.query()
                .fetch("vat")
                .where()
                .eq("fk_document",document.ID)
                .findList();

        System.out.println(document);

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

        //documentoDTO.imprimir();

        flash("success","Se imprimio correctamente el documento.");
        //Documento.guardar(documento);

        return redirect(routes.DocumentoController.verImprimirTicket());
    }
}
