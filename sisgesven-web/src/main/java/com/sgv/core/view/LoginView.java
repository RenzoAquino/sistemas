/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgv.core.view;

import java.util.Date;

import com.sgv.core.service.MainSystem;
import com.vaadin.event.ShortcutAction;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author renzo.aquino
 */
@SpringComponent
@UIScope
public class LoginView extends VerticalLayout implements View {
	public static final String VIEW_NAME = "login";
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MainSystem main = new MainSystem(); //link to backend
    
    TextField txtUsuario;
    PasswordField pwdContraseña;
    Button btnSignUp;
    Button btnLogin;
    
    public LoginView(){

        //UI Elements
        txtUsuario = new TextField("Usuario");
        pwdContraseña = new PasswordField("Contraseña");
        
        txtUsuario.setRequiredIndicatorVisible(true);
        pwdContraseña.setRequiredIndicatorVisible(true);
        
        //Add horizontal layout for buttons
        HorizontalLayout HLayout = new HorizontalLayout();
        
        //HARDCODE LOGIN -- **REMOVE LATER **
        Date date = new Date(); //today's date
        main.signUp("renzo.aquino.u", "Renzo Aquino Unocc", "12345", "Usuario", date, "Male");
        main.signUp("jomeine.aquino.u", "Jomeine kadafi Aquino Unocc", "12345", "Usuario", date, "Male");
        main.signUp("administrador", "Administrador", "12345", "Administrador", date, "Male");
        
        //UI Elements - Buttons
        btnLogin = new Button("Login");
        btnLogin.addStyleName("friendly");
        btnLogin.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        
        //Login Navigation
        btnLogin.addClickListener(new Button.ClickListener(){
            @Override
            public void buttonClick(Button.ClickEvent event) {
                if (main.Login(txtUsuario.getValue(), pwdContraseña.getValue())) {
                    //logged in successfully
                    getUI().getNavigator().navigateTo(DashboardView.VIEW_NAME);
                    
                    //reset UI Components
                    txtUsuario.setValue("");
                    pwdContraseña.setValue("");
                }else {
                    //incorrect login notification
                    Notification.show("¡Login Incorrecto!", Notification.Type.ERROR_MESSAGE);
                }
            }
            
        });
        
        btnSignUp = new Button("Registrar");
        btnSignUp.addStyleName("primary");
        
        //Navigation
        btnSignUp.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo("signup");
                
                //reset UI Components
                txtUsuario.setValue("");
                pwdContraseña.setValue("");
            }
        });
        
        HLayout.addComponent(btnLogin);
        HLayout.addComponent(btnSignUp);
        
        HLayout.setSpacing(true);
        
        //Form Layout
        FormLayout formLayout = new FormLayout(txtUsuario, pwdContraseña, HLayout);
        formLayout.setMargin(true);
        
        //Panel
        Panel loginPanel = new Panel("Sistema Gestión Venta", formLayout);
        loginPanel.setWidth("450");
        loginPanel.setHeight("250");
        //loginPanel.addStyleName("backColorGrey");
        
        
        //Add Components
        addComponent(loginPanel);
        setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);
        setHeight("100%");
        
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
       
    }
}
