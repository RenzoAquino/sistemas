package controllers;

import controllers.dto.ContabilidadDTO;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;


import javax.inject.Inject;



public class ContabilidadController extends Controller{

    @Inject
    FormFactory formFactory;



    public Result inicioLibroVenta(){

        ContabilidadDTO dto = new ContabilidadDTO();
/*        dto.tipoDetalle ="R";
        dto.listaTipoAccion = new ArrayList<String>();
        dto.listaTipoAccion.add("IMP");
*/
        Form<ContabilidadDTO> contabilidadDTOForm = formFactory.form(ContabilidadDTO.class).fill(dto);

        return ok();
        //return ok(libroVenta.render(contabilidadDTOForm));
    }

    public Result generarLibroVenta(){

        return ok();
    }
}
