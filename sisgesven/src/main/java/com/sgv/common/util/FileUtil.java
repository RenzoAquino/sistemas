package com.sgv.common.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    public static void createFile(String path, String name, String[] content) throws IOException {
        try {
            FileWriter writer = new FileWriter(path+name, false);
            
            for (String string : content) {
				writer.write(string);
				writer.write("\n");
			}
            
            //writer.write("\r\n");   // write new line
            
            writer.close();
        } catch (IOException e) {
        	e.printStackTrace();
        	throw e;           
        }
 
    }
    
    public static void leerCarpeta(String ruta, boolean soloArchivos) throws FileNotFoundException{
		System.out.println("iniciando leerCarpeta()...");       
        String files;
        File folder = new File(ruta);
        File[] listOfFiles = folder.listFiles();       
        
        if(listOfFiles == null) {
        	System.out.println("ALERTA - No se encontro la carpeta "+ruta); return;
        }
        
        for (int i = 0; i < listOfFiles.length; i++) 
        {
            if (listOfFiles[i].isFile()) 
            {
                files = listOfFiles[i].getName();
                
                if (files.endsWith(".pdf") || files.endsWith(".PDF"))
                {}
            }
        }
	}
}
