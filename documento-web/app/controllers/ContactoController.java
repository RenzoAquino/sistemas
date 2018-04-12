package controllers;

import controllers.dto.ContactoDTO;
import play.data.Form;
import play.mvc.Result;
import views.html.maestro.contacto;

public class ContactoController extends CommonController {

    public Result inicio(){
        ContactoDTO dto = new ContactoDTO();
        Form<ContactoDTO> form = formFactory.form(ContactoDTO.class).fill(dto);

        //return ok(generadorLibrosContables.render(form));
        return ok(contacto.render(form));
    }
}
