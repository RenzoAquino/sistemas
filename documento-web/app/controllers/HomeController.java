package controllers;

import play.mvc.*;

import views.html.index;

import views.html.Home.welcome;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a detDocumento message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render());
        /*
        int i = 50;

        String  name = "Debug";

        return ok("Hola Play");
        */
    }

    public Result welcome(String nombre, String apellido){
        //return ok("Hola "+nombre+" "+apellido+".");
        return ok(welcome.render(nombre,apellido));
    }
}
