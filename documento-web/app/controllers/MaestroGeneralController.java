package controllers;

import controllers.dto.MaestroGeneralDTO;
import play.data.Form;
import play.mvc.Result;
import views.html.maestro.maestroGeneral;

public class MaestroGeneralController extends CommonController {

    public Result inicio(){
        MaestroGeneralDTO dto = new MaestroGeneralDTO();
        Form<MaestroGeneralDTO> form = formFactory.form(MaestroGeneralDTO.class).fill(dto);

        //return ok(generadorLibrosContables.render(form));
        return ok(maestroGeneral.render(form));
    }
}
