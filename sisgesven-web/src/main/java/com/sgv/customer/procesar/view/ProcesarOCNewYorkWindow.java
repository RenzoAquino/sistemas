package com.sgv.customer.procesar.view;

import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.FailedEvent;
import com.vaadin.ui.Upload.FinishedEvent;
import com.vaadin.ui.Upload.StartedEvent;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Window;

//@StyleSheet("uploadexample.css")
public class ProcesarOCNewYorkWindow extends Window implements Upload.StartedListener, Upload.ProgressListener,
		Upload.FailedListener, Upload.SucceededListener, Upload.FinishedListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Label state = new Label();
	private final Label result = new Label();
	private final Label fileName = new Label();
	private final Label textualProgress = new Label();

	private final ProgressBar progressBar = new ProgressBar();
	private final Button cancelButton;
	private PDFReciver pdfReciver;
	
	public ProcesarOCNewYorkWindow(final Upload upload/*, final PDFReciver pdfReciver*/) {
		super("Estado");
		this.pdfReciver = (PDFReciver)upload.getReceiver();
		
		addStyleName("upload-info");
		
		setResizable(false);
		setDraggable(false);
		
		final FormLayout uploadInfoLayout = new FormLayout();
		setContent(uploadInfoLayout);
		uploadInfoLayout.setMargin(true);
		
		final HorizontalLayout stateLayout = new HorizontalLayout();
		stateLayout.setSpacing(true);
		stateLayout.addComponent(state);
		
		cancelButton = new Button("Cancelar");
		cancelButton.addClickListener(event -> upload.interruptUpload());
		cancelButton.setVisible(false);
		cancelButton.setStyleName("small");
		stateLayout.addComponent(cancelButton);
		
		stateLayout.setCaption("Estado Actual");
		state.setValue("Idle");
		uploadInfoLayout.addComponent(stateLayout);
		
		fileName.setCaption("Nombre de Archivo");
		uploadInfoLayout.addComponent(fileName);
		
		result.setCaption("Paginas Procesadas");
		uploadInfoLayout.addComponent(result);
		
		progressBar.setCaption("Progreso");
		progressBar.setVisible(false);
		uploadInfoLayout.addComponent(progressBar);
		
		textualProgress.setVisible(false);
		uploadInfoLayout.addComponent(textualProgress);
		
		upload.addStartedListener(this);
		upload.addProgressListener(this);
		upload.addFailedListener(this);
		upload.addSucceededListener(this);
		upload.addFinishedListener(this);

	}

	@Override
	public void uploadFinished(final FinishedEvent event) {
		state.setValue("Terminado");
		progressBar.setVisible(false);
		textualProgress.setVisible(false);
		cancelButton.setVisible(false);
	}

	@Override
	public void uploadStarted(final StartedEvent event) {
		// this method gets called immediately after upload is started
		progressBar.setValue(0f);
		progressBar.setVisible(true);
		UI.getCurrent().setPollInterval(500);
		textualProgress.setVisible(true);
		// updates to client
		state.setValue("Subiendo");
		fileName.setValue(event.getFilename());

		cancelButton.setVisible(true);
	}

	@Override
	public void updateProgress(final long readBytes, final long contentLength) {
		// this method gets called several times during the update
		progressBar.setValue(readBytes / (float) contentLength);
		textualProgress.setValue("Processed " + readBytes + " bytes of " + contentLength);
		result.setValue("Cargando...");
	}

	@Override
	public void uploadSucceeded(final SucceededEvent event) {
		try {
			result.setValue("Termino de cargar OC, inicía procesamiendo de OC.");
			//result.setValue(service.procesarOC(pdfReciver.AByte().toByteArray()) + " (total)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void uploadFailed(final FailedEvent event) {
		result.setValue("Carga interrumpida en el "
				+ Math.round(100 * progressBar.getValue()) + "%)");
	}
	
	public PDFReciver getPdfReciver() {
		return pdfReciver;
	}
}
