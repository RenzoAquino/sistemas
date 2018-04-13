package controllers;

import commons.Constantes;
import commons.util.CSVUtil;
import controllers.dto.ContabilidadDTO;
import models.sgv.Parametro;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import repository.ContabilidadService;
import views.html.contabilidad.*;


import javax.inject.Inject;



public class ContabilidadController extends Controller{

    @Inject
    FormFactory formFactory;



    public Result inicioGenerarLibro(){

        ContabilidadDTO dto = new ContabilidadDTO();
        dto.tipoLibro = new Parametro();
        dto.tipoLibro.id.codigo ="LVEN";
        dto.anio = new Parametro();
        dto.anio.id.codigo ="2018";
        dto.mes = new Parametro();
        dto.mes.id.codigo ="3"; //Simpre debe ser el mes anterior al actual

        Form<ContabilidadDTO> contabilidadDTOForm = formFactory.form(ContabilidadDTO.class).fill(dto);

/*
        EbeanServer db = DBConnectionUtil.getDBServerFacturador();
        List<BandejaFactura> lista = db.find(BandejaFactura.class).findList();; //BandejaFactura.find.all();//obtenerTodos();
        for (BandejaFactura x:lista) {
            System.out.println(x);
        }
*/
/*
        EbeanServer db = DBConnectionUtil.getDBServerSGV();
        List<ControlVenta> lista = db.find(ControlVenta.class)
                .where().ilike("CVNT_NUM_DOCUMENTO", "F002-00000213")
                .findList();
        for (ControlVenta x:lista) {
            System.out.println("*********** "+x);
        }
*/
/*
        EbeanServer db = DBConnectionUtil.getDBServerSGV();
        List<ControlVenta> lista = db.find(ControlVenta.class).findList();; //BandejaFactura.find.all();//obtenerTodos();
        for (ControlVenta x:lista) {
            System.out.println(x);
        }
*/

        return ok(generadorLibrosContables.render(contabilidadDTOForm));
    }

    public Result generarLibro() throws Exception {
        Form<ContabilidadDTO> form = formFactory.form(ContabilidadDTO.class).bindFromRequest();
        if(form.hasErrors()){
            flash("danger","Por favor corregir los errores del formulario");
            return badRequest(generadorLibrosContables.render(form));
        }

        if(form.get().tipoLibro.id.codigo.equals("0000")){
            flash("danger","Por favor seleccionar tipo de libro");
            return badRequest(generadorLibrosContables.render(form));
        }
        if(form.get().razonSocial.id.codigo.equals("0000")){
            flash("danger","Por favor seleccionar Razon Social");
            return badRequest(generadorLibrosContables.render(form));
        }

        if(form.get().mes.id.codigo.equals("0000")){
            flash("danger","Por favor seleccionar mes");
            return badRequest(generadorLibrosContables.render(form));
        }

        if(form.get().anio.id.codigo.equals("0000")){
            flash("danger","Por favor seleccionar Año");
            return badRequest(generadorLibrosContables.render(form));
        }

        ContabilidadDTO dto = form.get();
        System.out.println(dto);
        String nombreArchivo = dto.razonSocial.id.codigo+"-"+dto.tipoLibro.id.codigo+"-"+dto.anio.id.codigo+"."+dto.mes.id.codigo+ Constantes.EXTENSION_CSV;
        String cabeceraArchivoCsv = "";

        if (dto.tipoLibro.id.codigo.equals("LVEN")){
            cabeceraArchivoCsv = Constantes.CABECERA_CSV_LIBRO_VENTA;
        } else if (dto.tipoLibro.id.codigo.equals("ANUL")){
            cabeceraArchivoCsv = Constantes.CABECERA_CSV_ANULACIONES;
        }

        return ok(CSVUtil.generarCSV(ContabilidadService.obtenerDatosControlMovimientos(dto), cabeceraArchivoCsv,Constantes.RUTA_ARCHIVO_CSV), nombreArchivo);
    }

}
