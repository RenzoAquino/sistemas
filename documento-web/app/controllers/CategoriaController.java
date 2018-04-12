package controllers;

import controllers.dto.CategoriaDTO;
import play.data.Form;
import play.mvc.Result;
import views.html.maestro.categoria;

public class CategoriaController extends CommonController {

    public Result inicio(){
        CategoriaDTO dto = new CategoriaDTO();
        Form<CategoriaDTO> form = formFactory.form(CategoriaDTO.class).fill(dto);

        //return ok(generadorLibrosContables.render(form));
        return ok(categoria.render(form));
    }
}
