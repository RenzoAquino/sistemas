/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgv.core.view;

import com.sgv.core.service.MainSystem;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author renzo.aquino
 */
@SuppressWarnings("serial")
@SpringComponent
@UIScope
public class EnviarDocumentoView extends VerticalLayout implements View {
	public static final String VIEW_NAME = "enviarDocumento";
	
    MainSystem main = new MainSystem();

    Label lblTitle;
    Label lblSection;
    TextField tfClassID;
    TextField tfClassName;
    Button btnConfirm;
    
    FormLayout form;
    HorizontalLayout footer;
    
    public EnviarDocumentoView() {
        
        //initial setup
        setSpacing(true);
        setMargin(true);
        
        //setting up standard title
        lblTitle = new Label("Envío de Documento a SUNAT");
        lblTitle.addStyleName("h1");
        addComponent(lblTitle);
                
        form = new FormLayout();
        form.setMargin(false);
        form.setWidth("900");
        form.addStyleName("light");
        addComponent(form);
        
        lblSection = new Label("Detalle de Documento");
        lblSection.addStyleName("h2");
        lblSection.addStyleName("colored");
        form.addComponent(lblSection);
        
        tfClassID = new TextField("Class ID");
        tfClassID.setRequiredIndicatorVisible(true);
        form.addComponent(tfClassID);
        
        tfClassName = new TextField("Class Name");
        tfClassName.setRequiredIndicatorVisible(true);
        form.addComponent(tfClassName);
        
        btnConfirm = new Button("Confirm");
        btnConfirm.addStyleName("primary");
        btnConfirm.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                //add class to teacher
                main.addClassToTeacher(tfClassID.getValue(), tfClassName.getValue());
                Notification.show("Class Added");
                
                //reset UI
                tfClassID.setValue("");
                tfClassName.setValue("");
            }
        });
        
         //horizontal layout for button
         footer = new HorizontalLayout();
         footer.setMargin(new MarginInfo(true,false,true,false));
         footer.setSpacing(true);
         footer.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
         form.addComponent(footer);
         footer.addComponent(btnConfirm);
        
        
        
        
        
        
    }
        
    

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        
    }
}
