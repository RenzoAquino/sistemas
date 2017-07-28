package com.sgv.customer.procesar.view;

import org.springframework.beans.factory.annotation.Autowired;

import com.sgv.customer.procesar.service.ProcesarOCService;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;

@SpringComponent
public class ProcesarOCNewYorkView extends VerticalLayout implements View{
	public static final String VIEW_NAME = "procesarOCNewYork";
	
	ProcesarOCNewYorkWindow procesarOC;
	
	@Autowired
	ProcesarOCService service;
    PDFReciver pdfReciver;
    Upload  upload;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProcesarOCNewYorkView() {
		
        setWidth(100.0f, Unit.PERCENTAGE);
                
        pdfReciver = new PDFReciver();
        //lineBreakCounter.setSlow(true);
 
        upload = new Upload();
        upload.setReceiver(pdfReciver);
        //upload.addStyleName("v-upload");
        upload.setDescription("Seleccionar Orden de Compra para ser procesado.");
        //upload.setIcon(FontAwesome.SAVE);
        upload.setImmediateMode(false);
        upload.setButtonCaption("Subir Archivo");
 
        procesarOC = new ProcesarOCNewYorkWindow(upload);
 
        upload.addStartedListener(event -> {
            if (procesarOC.getParent() == null) {
                UI.getCurrent().addWindow(procesarOC);
            }
            procesarOC.setClosable(false);
        });
        upload.addFinishedListener(event -> {
        	procesarOC.setClosable(true);
        	procesarOCCargada(upload);
        	});

        addComponent(upload);
    }

	private void procesarOCCargada(Upload upload) {
		this.pdfReciver = (PDFReciver)upload.getReceiver();
		System.out.println("ProcesarOCNewYorkView - SERVICE ES : "+service);
		//System.out.println("***************** "+this.pdfReciver.AByte());
		try {
			System.out.println(service.procesarOC(this.pdfReciver.AByte().toByteArray()) + " (total)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		//NO INGRESA :(
	}
}
