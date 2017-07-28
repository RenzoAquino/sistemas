package com.sgv.core.view;

import org.springframework.beans.factory.annotation.Autowired;

import com.sgv.core.service.MainSystem;
import com.sgv.customer.procesar.service.EquivalenciaProductoService;
import com.sgv.customer.procesar.view.ProcesarOCNewYorkView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author renzo.aquino
 */
@SuppressWarnings("serial")
@SpringComponent
@UIScope
public class DashboardView extends VerticalLayout implements View {
	public static final String VIEW_NAME = "dashboard";
	
    MainSystem main = new MainSystem(); //link to backend
    
    HorizontalLayout upperSection = new HorizontalLayout();
    HorizontalLayout innerUpperSection = new HorizontalLayout();
    HorizontalSplitPanel lowerSection = new HorizontalSplitPanel();
    VerticalLayout menuLayout = new VerticalLayout();
    HorizontalLayout menuTitle = new HorizontalLayout();
    VerticalLayout contentLayout = new VerticalLayout();
    
    Label lblHeader;
    Label lblMenu;
    Button btnLogout;
    @Autowired
    EnviarDocumentoView enviarDocumento;
    @Autowired
    ConsolidarInformacionView consolidarInformacion;
    @Autowired
    ProcesarOCNewYorkView procesarOC;
    //@Autowired
    //EquivalenciaProductoService service;
    
    public DashboardView() {
    	
        //UI Components
        
        lblHeader = new Label("");  //will change later
        lblHeader.addStyleName("colored");
        lblHeader.addStyleName("h2");
        lblHeader.setSizeUndefined();
        
        btnLogout = new Button("Sign Out");
        btnLogout.addStyleName("small");
        btnLogout.addStyleName("friendly");
        btnLogout.setSizeUndefined();
        btnLogout.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                //logout using backend
                main.Logout();
                
                //navigate back to login page
                getUI().getNavigator().navigateTo(LoginView.VIEW_NAME);
            }
        });
        
        lblMenu = new Label("Menu");
        lblMenu.addStyleName("colored");
        lblMenu.addStyleName("h2");
        
        //Sections
        innerUpperSection.addComponent(lblHeader);
        innerUpperSection.addComponent(btnLogout);
        innerUpperSection.setExpandRatio(btnLogout, 1);
        innerUpperSection.setSpacing(true);
        innerUpperSection.setComponentAlignment(btnLogout, Alignment.MIDDLE_RIGHT);
        
        upperSection.setSizeFull();
        upperSection.addComponent(innerUpperSection);
        
        upperSection.setMargin(new MarginInfo(false, true, false, false));
        upperSection.setComponentAlignment(innerUpperSection, Alignment.TOP_RIGHT);
        upperSection.addStyleName("borderBottom");
        upperSection.setHeight(4, UNITS_EM);
        
        //menu section
        menuTitle.addComponent(lblMenu);
        menuLayout.addComponent(menuTitle);
        menuLayout.setWidth("100%");
        menuLayout.setComponentAlignment(menuTitle, Alignment.MIDDLE_CENTER);
        
        lowerSection.addComponent(menuLayout);
        lowerSection.addComponent(contentLayout);
        contentLayout.setSizeFull();
        lowerSection.setSizeFull();
        lowerSection.setSplitPosition(15);
        
        addComponent(upperSection);
        addComponent(lowerSection);
        
        setSizeFull();
        
        setExpandRatio(lowerSection,1);
        
        
    }

    public void setMenuTitle() {
        //set the menu title
        menuTitle.addComponent(lblMenu);
        menuLayout.addComponent(menuTitle);
        menuLayout.setWidth("100%");
        menuLayout.setComponentAlignment(menuTitle, Alignment.MIDDLE_CENTER);
        
    }
    
    public void addWelcomeText() {
        //create new label for welcome text
        Label lblTitle = new Label("Bienvenido " + main.getCurrentUser().getName() + "!");
        lblTitle.addStyleName("h1");
        lblTitle.addStyleName("colored");
        
        lblHeader.setValue("" + main.getCurrentUser().getType());
        
        contentLayout.addComponent(lblTitle);
        contentLayout.setMargin(new MarginInfo(false, false, false, true));

    }
    
    public void addDashboardOption(String caption) {
        //set menu buttons
        
        Button button = new Button(caption);
        button.setWidth("100%");
        button.setStyleName("borderless");
        menuLayout.addComponent(button);
        //menuLayout.setComponentAlignment(button, Alignment.MIDDLE_LEFT);
        
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                contentLayout.removeAllComponents();    //remove everything from the content screen section
                addWelcomeText();
            }
            
        });
    }
    
    public Component getComponent(String componentName) {
    	
        if (componentName.equals(EnviarDocumentoView.VIEW_NAME)) {
        	//enviarDocumento = new EnviarDocumentoView();
            return enviarDocumento;
        } else if (componentName.equals(ProcesarOCNewYorkView.VIEW_NAME)) {
        	//procesarOC = new ProcesarOCNewYorkView();
            return procesarOC;
        } else if (componentName.equals(ConsolidarInformacionView.VIEW_NAME)) {
        	//consolidarInformacion = new ConsolidarInformacionView();
            return consolidarInformacion;
        }else {        
        	//enviarDocumento = new EnviarDocumentoView();
            return enviarDocumento;//new LoginView();
        }
    }
    
    public void addMenuOption(String caption, String componentName) {
        Button button = new Button(caption);
        button.setWidth("100%");
        button.setStyleName("borderless");
        menuLayout.addComponent(button);
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                contentLayout.removeAllComponents();
                contentLayout.addComponent(getComponent(componentName));
            }
            
        });
    }
    
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    	//System.out.println("DashboardView - SERVICE ES : "+service);
    	//System.out.println("Tamañano : "+service.obtenerListaEquivalenciaProductos("20549706500").size());
    	
    	
    	//Temporal security
        if(main == null || main.getCurrentUser() == null) {
            //navigate back to login page
            getUI().getNavigator().navigateTo(LoginView.VIEW_NAME);
            return;
        }
    	
    	//reset screen
        menuLayout.removeAllComponents();
        contentLayout.removeAllComponents();
        
        //add components
        setMenuTitle();
        this.addDashboardOption("Dashboard");
        if (main.getCurrentUser().getType().equals("Administrador")){
        	this.addMenuOption("Procesar OC", ProcesarOCNewYorkView.VIEW_NAME);
        	this.addMenuOption("Enviar Documento", EnviarDocumentoView.VIEW_NAME);
        	this.addMenuOption("Consolidar Información", ConsolidarInformacionView.VIEW_NAME);
        }else{
        	this.addMenuOption("Enviar Documento", EnviarDocumentoView.VIEW_NAME);
        	this.addMenuOption("Consolidar Información", ConsolidarInformacionView.VIEW_NAME);        	
        }
        
        addWelcomeText();
    }
}
