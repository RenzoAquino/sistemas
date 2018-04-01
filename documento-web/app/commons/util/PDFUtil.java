package commons.util;

import commons.Constantes;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.PDSimpleFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.tools.TextToPDF;

import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PDFUtil {

    public static void convertirTXTaPDF(String nombreArchivoPdf) throws IOException, PrinterException, InterruptedException {

        PDDocument document = new PDDocument();
        TextToPDF pdf = new TextToPDF();
        File pdfFile = new File("D:\\SISGESVEN\\TICKETS\\"+nombreArchivoPdf);//new File(nombreArchivoPDF);

        BufferedReader reader = new BufferedReader(new FileReader(Constantes.NOMBRE_ARCHIVO_TXT));

        PDSimpleFont courier = PDType1Font.COURIER;
        PDSimpleFont testFont = PDTrueTypeFont.loadTTF( document, new File("times.ttf" ));

        //pdf.setFont(testFont);
        pdf.setFont(courier);
        pdf.setFontSize(8);


        pdf.createPDFFromText(document, reader);

        document.save(pdfFile);
        document.close();


        /*
        PDDocument doc = PDDocument.load(new File(nombreArchivoPDF));
        PDFPrintable printable = new PDFPrintable(doc, Scaling.SHRINK_TO_FIT);
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(printable);
        job.print();
        */

    }
}
