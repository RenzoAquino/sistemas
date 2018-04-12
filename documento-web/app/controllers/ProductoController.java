package controllers;

import controllers.dto.ProductoDTO;
import play.data.Form;
import play.mvc.Result;
import views.html.maestro.producto;

public class ProductoController extends CommonController {

    public Result inicio(){
        ProductoDTO dto = new ProductoDTO();
        Form<ProductoDTO> form = formFactory.form(ProductoDTO.class).fill(dto);

        //return ok(generadorLibrosContables.render(form));
        return ok(producto.render(form));
    }
}
