package controllers;

import play.data.FormFactory;
import play.mvc.Controller;

import javax.inject.Inject;

public class CommonController extends Controller {

    @Inject
    protected FormFactory formFactory;

}
