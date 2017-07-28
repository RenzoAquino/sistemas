package com.sgv.customer.procesar.view;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Component;

import com.vaadin.ui.Upload.Receiver;


public class PDFReciver implements Receiver {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ByteArrayOutputStream aByte;

	@Override
	public OutputStream receiveUpload(final String filename, final String MIMEType) {
		aByte = new ByteArrayOutputStream();
		return aByte;
	}

	public ByteArrayOutputStream AByte() {
		return aByte;
	}

}
