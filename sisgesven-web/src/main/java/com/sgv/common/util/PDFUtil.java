package com.sgv.common.util;

import java.io.IOException;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

public class PDFUtil {

	public static PdfReader obternerPdfReader(byte[] aByte){
		
		 PdfReader reader = null;
         //PdfReaderContentParser parser;
         //TextExtractionStrategy strategy;
 		try {
 			reader = new PdfReader(aByte);
 	        
 	        System.out.println("********************* "+reader.getNumberOfPages());
 	        
 	       //result.setValue(reader.getNumberOfPages() + " (Paginas)");
 		} catch (IOException e1) {
 			e1.printStackTrace();
 		}
 		//reader.close();
 		return reader;
	}
	
	
	public static String[][] obtenerTextoPDF(byte[] aByte){
		return obtenerTextoPDF(obternerPdfReader(aByte));
	}
	
	public static String[][] obtenerTextoPDF(PdfReader reader){
		
		//Declarar variables
        PdfReaderContentParser parser;
        TextExtractionStrategy strategy;
        String string;
        //String[] arregloString;
        String[][] arregloTexto;        
        
        //Inicializar variables
        parser = new PdfReaderContentParser(reader);
        arregloTexto = new String[reader.getNumberOfPages()][];
        
        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            try {
				strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
	            string = strategy.getResultantText();
	            //arregloString = string.split("\n");
	            arregloTexto[(i-1)] = string.split("\n");//new String[0];
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        return arregloTexto;
	}
}
