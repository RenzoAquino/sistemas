package commons.util;

import commons.Constantes;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ImpresoraUtil {

    public static void enviarAImpresora( ) throws IOException {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(Constantes.NOMBRE_ARCHIVO_TXT);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        if (inputStream == null) {
            return;
        }

        //DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;


        //PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
        //attributeSet.add(OrientationRequested.PORTRAIT);
        //attributeSet.add(new Copies(2));

        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

        PrintService printService[] = PrintServiceLookup.lookupPrintServices(
                flavor, pras);

        PrintService service = null;

        for (PrintService service_ : printService) {
            System.out.println("********************"+service_.getName());
            if (service_.getName().equalsIgnoreCase(Constantes.NOMBRE_IMPRESORA)) {
                service = service_;
                break;
            }
        }

        //PrintService service = findPrintService(Constantes.NOMBRE_IMPRESORA, printService);
        //PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

        System.out.println("PrintService :"+service);

        Doc document = new SimpleDoc(inputStream, flavor, null);
        DocPrintJob printJob;
        if (service != null) {

            printJob = service.createPrintJob();
            /*    printJob.addPrintJobListener(new JobCompleteMonitor());*/
            try {

                printJob.print(document, pras);
                printJob = service.createPrintJob();
                //byte[] bytes = {27, 100, 3};  //CORTE DE HOJA: Para impresora STAR
                byte[] cutP = new byte[] { 0x1d, 'V', 1 };  //CORTE DE HOJA: Para impresora BIXOLON
                flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
                document = new SimpleDoc(cutP, flavor, null);

                printJob.print(document, null);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            System.err.println("No existen impresoras instaladas");
        }

        inputStream.close();
    }
    /*
    private PrintService findPrintService(String printerName,
                                          PrintService[] services) {
        for (PrintService service : services) {
            System.out.println("********************"+service.getName());
            if (service.getName().equalsIgnoreCase(printerName)) {
                return service;
            }
        }

        return null;
    }
    */
}
