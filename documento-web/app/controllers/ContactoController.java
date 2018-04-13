package controllers;

import commons.util.DBConnectionUtil;
import controllers.dto.ContactoDTO;
import io.ebean.EbeanServer;
import io.ebean.Expr;
import models.Documento;
import models.sgv.Contacto;
import play.data.Form;
import play.mvc.Result;
import repository.sgv.ContactoService;
import views.html.documento.ver;
import views.html.errors._404;
import views.html.maestro.contacto.listado;
import views.html.maestro.contacto.crear;

import java.util.List;

public class ContactoController extends CommonController {


    public Result inicio(){
        EbeanServer db = DBConnectionUtil.getDBServerSGV();

        List<Contacto> lista = db.find(Contacto.class).findList(); //Contacto.find.all();
        System.out.println("**********inicio size lista "+lista.size());
        for (Contacto obj: lista) {
            System.out.println("********** "+obj.id);
            System.out.println("********** "+obj.direccion);
        }

        //return ok(generadorLibrosContables.render(form));
        return ok(listado.render(lista));
    }

    public Result buscar() throws Exception {
        Form<ContactoDTO> form = formFactory.form(ContactoDTO.class).bindFromRequest();

        List<Contacto> lista = ContactoService.obtenerListaContactos(form.get());
        if(lista.size() == 0)
            flash("info","No se encontraron resultados");
        for (Contacto x:lista) {
            System.out.println("*********** "+x);
        }

        return ok(listado.render(lista));
    }

    // para crear
    public Result crear(){
        Form<Contacto> form = formFactory.form(Contacto.class);

        return ok(crear.render(form));
    }
    // para guardar
    public Result guardar(){
        Form<Contacto> form = formFactory.form(Contacto.class).bindFromRequest();
        if(form.hasErrors()){
            flash("danger","Por favor corregir los errores del formulario");
            return badRequest(crear.render(form));
        }

        //Contacto objeto = form.get();
        //objeto.save();
        ContactoService.crearContacto(form.get());

        flash("success","Se creo correctamente el Contacto.");
        //Documento.guardar(documento);

        return redirect(routes.ContactoController.inicio());
    }
}
