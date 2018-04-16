package controllers;

import commons.Constantes;
import commons.DatosSession;
import commons.util.GeneradorCodigoUtil;
import controllers.dto.ContactoDTO;

import models.sgv.Contacto;
import play.data.Form;
import play.mvc.Result;
import repository.sgv.ContactoService;
import repository.sgv.ParametroService;
import views.html.errors._404;
import views.html.maestro.contacto.crear;
import views.html.maestro.contacto.editar;
import views.html.maestro.contacto.listado;
import views.html.maestro.contacto.ver;

import java.util.List;

public class ContactoController extends CommonController {


    public Result inicio(String tipo) throws Exception {
        ContactoDTO dto = new ContactoDTO();
        dto.tipoContacto = tipo;
        List<Contacto> lista = ContactoService.obtenerListaContactos(dto); //Documento.find.all();
        System.out.println("ContactoController.inicio listasize "+lista.size());
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
    public Result crear(String tipo) throws Exception {
        Contacto obj = new Contacto();
        obj.codigo = GeneradorCodigoUtil.generarCodigoCliente(tipo);
        obj.tipoContacto = ParametroService.obtenerTipoContacto(tipo);
        System.out.println("ContactoController.crear : "+obj);
        Form<Contacto> form = formFactory.form(Contacto.class).fill(obj);

        return ok(crear.render(form));
    }

    public Result editar(Long id){
        Contacto obj = ContactoService.obtenerPorId(id);
        System.out.println("editar "+obj);
        if(obj==null)
            return notFound(_404.render());

        Form<Contacto> form = formFactory.form(Contacto.class).fill(obj);

        return ok(editar.render(form));
    }
    // para actualizar
    public Result guardar() throws Exception {
        Form<Contacto> form = formFactory.form(Contacto.class).bindFromRequest();
        if(form.hasErrors()){
            flash("danger","Por favor corregir los errores del formulario");
            return badRequest(crear.render(form));
        }

        //obj.save();
        ContactoService.crear(form.get());

        flash("success","Se guardo correctamente el Documento.");
        //Documento.actualizar(documento);

        return redirect(routes.ContactoController.inicio(form.get().tipoContacto.id.codigo));
    }
    public Result actualizar(Long id){

        Form<Contacto> form = formFactory.form(Contacto.class).bindFromRequest();
        if(form.hasErrors()){
            flash("danger","Por favor corregir los errores del formulario");
            return badRequest(editar.render(form));
        }

        Contacto obj = form.get();
        Contacto oldObj = ContactoService.obtenerPorId(id);
        if(oldObj==null) {
            flash("danger", "Contacto no encontrado");
            return notFound();
        }
        if(oldObj.id !=obj.id) {
            flash("danger", "El identificador del Contacto no coincide con el de la DB");
            return notFound();
        }

        ContactoService.actualizar(obj);

        System.out.print("Termino de actualizar");

        flash("success","Se actualizo correctamente el Contacto.");
        return ok();
    }

    public Result eliminar(Long id){
        Contacto obj = ContactoService.obtenerPorId(id);
        if(obj==null) {
            flash("danger", "Contacto no encontrado");
            return notFound();
        }
        ContactoService.eliminar(obj);

        flash("success","Se elimino correctamente el contacto.");

        //return ok();
        return redirect(routes.ContactoController.inicio(obj.tipoContacto.id.codigo));
    }

    // para el detalle
    public Result ver(Long id){
        Contacto obj = ContactoService.obtenerPorId(id);
        if(obj == null)
            return notFound(_404.render());

        return ok(ver.render(obj));
    }
}
