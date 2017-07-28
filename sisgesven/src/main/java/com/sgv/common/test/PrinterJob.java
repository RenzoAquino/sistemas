package com.sgv.common.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.Sides;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;
import javax.print.event.PrintJobListener;

public class PrinterJob {
	private static boolean jobRunning = true;
	public static void main(String[] args) throws PrintException, IOException, InterruptedException {
		
		FileInputStream fis = new FileInputStream("D:/WS_FAKTURAMA/WS_INVERSIONES_UNOCC/out/PD-000063-RESTOBAR_3_MARES_SAC.PDF");
		Doc pdfDoc = new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
		
		PrintService  myservice = PrintServiceLookup.lookupDefaultPrintService();
		
		try {
			myservice.createPrintJob().print(pdfDoc, null);
	    } catch (PrintException e) {
	        e.printStackTrace();
	    } finally {
	    	fis.close();
		}
		
		/*
		DocFlavor psInFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
		//Doc myDoc = new SimpleDoc(fis, psInFormat, null);  
		PrintRequestAttributeSet aset = 
		        new HashPrintRequestAttributeSet();
		aset.add(new Copies(1));
		aset.add(MediaSizeName.ISO_A4);
		aset.add(Sides.DUPLEX);
		PrintService[] services = 
		  PrintServiceLookup.lookupPrintServices(psInFormat, aset);
		if (services.length > 0) {
		   DocPrintJob job = services[0].createPrintJob();
		   try {
		        job.print(pdfDoc, aset);
		   } catch (PrintException pe) {}
		}
		*/
		
		/*
		PrintService myService = null;
		
	    DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PAGEABLE;
	    PrintRequestAttributeSet patts = new HashPrintRequestAttributeSet();
	    patts.add(Sides.DUPLEX);
	    //patts.add(Sides.ONE_SIDED);
	    PrintService[] ps = PrintServiceLookup.lookupPrintServices(flavor, patts);
	    if (ps.length == 0) {
	        throw new IllegalStateException("No Printer found");
	    }
	    System.out.println("Available printers: " + Arrays.asList(ps));

	    
	    for (PrintService printService : ps) {
	    	//System.out.println("name ["+printService+"]");
	        if (printService.getName().endsWith("Canon MG5700 series Printer")) {
	        	System.out.println("ingreso a ["+printService+"]");
	            myService = printService;
	            break;
	        }
	    }

	    if (myService == null) {
	        throw new IllegalStateException("Printer not found");
	    }
	    
	    DocPrintJob printJob = myService.createPrintJob();
	    printJob.print(pdfDoc, null);
	    
	   

	  System.out.println("Exiting app");
	    fis.close();  
	    */    
	}
	
}
