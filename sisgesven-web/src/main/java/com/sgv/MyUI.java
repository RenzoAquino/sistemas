package com.sgv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import com.sgv.core.view.DashboardView;
import com.sgv.core.view.LoginView;
import com.sgv.customer.procesar.service.EquivalenciaProductoService;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@SpringUI
@Theme("valo")
//@Theme("custom")
//@ComponentScan("com.sgv.customer.procesar.service")
public class MyUI extends UI {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Navigator navigator;
	LoginView login;
	DashboardView dashboard;
/*	
	@Autowired
	EquivalenciaProductoService service;
*/
    @Autowired
    public MyUI(LoginView login,DashboardView dashboard){
    	this.navigator = new Navigator(this,this);
    	this.login = login;
    	this.dashboard = dashboard;
    }
    
    @Override
    protected void init(VaadinRequest request) {
    	/*
    	System.out.println("********** request foo01 ["+request.getParameter("foo01")+"]");
    	System.out.println("********** request foo02 ["+request.getParameter("foo02")+"]");
    	System.out.println("********** VaadinService foo01 ["+VaadinService.getCurrentRequest().getParameter("foo01")+"]");    	
    	System.out.println("********** VaadinService foo02 ["+VaadinService.getCurrentRequest().getParameter("foo02")+"]");
    	*/
        //Login
    	//navigator.addView("", login);
        navigator.addView(LoginView.VIEW_NAME, login);

        //Sign Up
        //navigator.addView("signup", new SignUpForm());
        
        //Usuario/Administrador Dashboard
        navigator.addView(DashboardView.VIEW_NAME, dashboard);
        
        //Begin login view
        navigator.navigateTo(LoginView.VIEW_NAME);  
        
        //System.out.println("MyUI - SERVICE ES : "+service);
        //System.out.println("MyUI - Tamañano : "+service.obtenerListaEquivalenciaProductos("20549706500").size());
    	
    }
/*    
    @WebListener
    public static class MyContextLoaderListener extends ContextLoaderListener {
    }

    @Configuration
    @EnableVaadin
    public static class MyConfiguration {
    }

    @WebServlet(urlPatterns = { "/myui/*", "/VAADIN/*" }, name = "MyUIServlet", asyncSupported = true)
    //@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = true)
    public static class MyUIServlet extends SpringVaadinServlet {
    }
*/   
}