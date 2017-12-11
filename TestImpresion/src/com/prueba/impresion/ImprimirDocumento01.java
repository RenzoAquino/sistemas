package com.prueba.impresion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;

import com.rau.util.impresion.pos.Extenso;
import com.rau.util.impresion.pos.PrinterMatrixOriginal;

public class ImprimirDocumento01 {

	public static void main(String[] args) {
		ImprimirDocumento01 print = new ImprimirDocumento01();
		print.imprimirTicketinicio();
	}

	
	void imprimirTicketinicio(){

		try {

		PrinterMatrixOriginal printer = new PrinterMatrixOriginal();

		Extenso e = new Extenso();

		e.setNumber(20.30);

		//Definir el tamanho del papel para la impresion de dinamico y 32 columnas
		int filas = 2;//punto_Venta.jtbl_venta.getRowCount();
		int tamaño = filas+13;
		printer.setOutSize(tamaño, 32);

		//Imprimir = 1ra linea de la columa de 1 a 32
		printer.printTextWrap(0, 1, 0, 32, "================================");
		printer.printTextWrap(1, 1, 0, 32, " Nombre del negocio ");
		printer.printTextWrap(3, 1, 0, 32, " direccion ");
		printer.printTextWrap(4, 1, 0, 32, " direccion ");
		printer.printTextWrap(5, 1, 0, 32, " codigo postal y rf ");
		printer.printTextWrap(6, 1, 0, 17, "Fecha: " + "10/10/2017");//punto_Venta.jL_fecha.getText());
		printer.printTextWrap(6, 1,18, 32, "Hora: " + "20:30:59");//punto_Venta.jL_hora.getText());
		printer.printTextWrap(7, 1, 0, 32, "Numero de Venta: "+ "1234");//punto_Venta.jtx_id_venta.getText());
		printer.printTextWrap(8, 1, 0, 32, "Le atendio: "+ "jomeine");//punto_Venta.jtx_vendedor.getText());
		printer.printTextWrap(9, 1, 0, 32, "Cliente: " + "rex bakery");//punto_Venta.jtx_cliente.getText());
		printer.printTextWrap(10,1, 0, 32, "——————————–");
		printer.printTextWrap(11,1, 0, 32, "DESCRIPCION CANT PRECIO IMPORTE");
		printer.printTextWrap(12,1, 0, 32, " ");
		for (int i = 0; i < filas; i++) {
		int p = 13+i;
		printer.printTextWrap(p , 1, 0, 12 ,"descripc "+p);//punto_Venta.jtbl_venta.getValueAt(i,1).toString());
		printer.printTextWrap(p , 1, 13, 16, ""+(p*2));//punto_Venta.jtbl_venta.getValueAt(i,5).toString());
		String pre= printer.alinharADireita(7, "23");//punto_Venta.jtbl_venta.getValueAt(i,4).toString());
		printer.printTextWrap(p , 1, 17, 24, pre);
		String inp= printer.alinharADireita(7,"89");//punto_Venta.jtbl_venta.getValueAt(i,6).toString());
		printer.printTextWrap(p , 1, 25, 32, inp);

		}
		///CREAR CARPETA tmp EN UNIDAD C
		printer.toFile("C:\\tmp\\impresion.txt");

		FileInputStream inputStream = null;
		try {
		inputStream = new FileInputStream("C:\\tmp\\impresion.txt");
		} catch (FileNotFoundException ex) {
		ex.printStackTrace();
		JOptionPane.showMessageDialog(null/*punto_Venta*/, "Error al guardar");

		}
		if (inputStream == null) {
		return;
		}

		DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
		Doc document = new SimpleDoc(inputStream, docFormat, null);

		PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();

		PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

		if (defaultPrintService != null) {
		DocPrintJob printJob = defaultPrintService.createPrintJob();
		try {
		printJob.print(document, attributeSet);

		} catch (Exception ex) {
		ex.printStackTrace();
		}
		} else {
		System.err.println("No existen impresoras instaladas");
		}

		inputStream.close();
		imprimirFin();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null/*punto_Venta*/, "Error al imprimir");
		}
		}

		void imprimirFin(){

		PrinterMatrixOriginal printer = new PrinterMatrixOriginal();

		Extenso e = new Extenso();

		e.setNumber(20.30);

		printer.setOutSize(15,32);
		DecimalFormat formateador = new DecimalFormat("######.00");
		String sub= printer.alinharADireita(10,"223");//punto_Venta.jtxt_subtotal.getText());
		printer.printTextWrap(1, 1, 5, 32, "Subtotal "+sub);
		String tot= printer.alinharADireita(10,"800");//punto_Venta.jtxt_total.getText());
		printer.printTextWrap(2, 1, 5, 32, "Total a pagar $"+tot);

		String efe= printer.alinharADireita(10,"23432");//punto_Venta.jtx_efectivo.getText());
		printer.printTextWrap(3, 1, 5, 32, "Efectivo $"+efe);
		String cam= printer.alinharADireita(10,"0990");//punto_Venta.jtx_cambio.getText());
		printer.printTextWrap(4, 1, 5, 32, "Cambio $"+ cam);
		printer.printTextWrap(5, 1, 0,32, "——————————–");
		printer.printTextWrap(6, 1, 0,32, " !Gracias por su preferencia! ");
		printer.printTextWrap(7, 1, 0,32, "================================");

		printer.toFile("C:\\tmp\\impresion1.txt");

		FileInputStream inputStream = null;
		try {
		inputStream = new FileInputStream("C:\\tmp\\impresion1.txt");
		} catch (FileNotFoundException ex) {
		ex.printStackTrace();
		}
		if (inputStream == null) {
		return;
		}

		DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
		Doc document = new SimpleDoc(inputStream, docFormat, null);

		PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();

		PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

		if (defaultPrintService != null) {
		DocPrintJob printJob = defaultPrintService.createPrintJob();
		try {
		printJob.print(document, attributeSet);

		} catch (Exception ex) {
		ex.printStackTrace();
		}
		} else {
		System.err.println("No existen impresoras instaladas");
		}

		//inputStream.close();
        System.out.println("*******");

        DocPrintJob job = PrintServiceLookup.lookupDefaultPrintService().createPrintJob();  
        //byte[] bytes = {27, 100, 3};
        byte[] cutP = new byte[] { 0x1d, 'V', 1 };
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        Doc doc = new SimpleDoc(cutP, flavor, null);
        try {
			job.print(doc, null);
		} catch (PrintException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        System.out.println("*******");
		}
}
