package commons.util;

import commons.Constantes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

public class HttpUtil {

    public static void enviarParametroPaginaWeb(String direccionWeb, List<String> parametros) throws Exception {
        BufferedReader reader = null;
        try {

        URL url = new URL(direccionWeb);
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
        System.out.println("HttpUtil.enviarParametroPaginaWeb ----> URL: ["+direccionWeb+"]");
        System.out.println("HttpUtil.enviarParametroPaginaWeb----> PARAMETROS: ["+String.join(Constantes.WEB_UNIR_PARAMETRO, parametros)+"]");
        writer.write(String.join(Constantes.WEB_UNIR_PARAMETRO, parametros));
        writer.flush();
        String line;

        reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((line = reader.readLine()) != null) {
            //System.out.println("HttpUtil.enviarParametroPaginaWeb ----> RPTA: "+line);
        }

        writer.close();
        reader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            // close the reader; this can throw an exception too, so
            // wrap it in another try/catch block.
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch (IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
        }
    }

    public static void consultarpaginaWeb(String direccionWeb, String tipoEnvio) throws Exception {
        URL url = null;
        BufferedReader reader = null;

        try
        {
            // create the HttpURLConnection
            url = new URL(direccionWeb);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // just want to do an HTTP GET here
            connection.setRequestMethod(tipoEnvio);

            // uncomment this if you want to write output to this url
            //connection.setDoOutput(true);

            // give it 15 seconds to respond
            connection.setReadTimeout(15*1000);
            connection.connect();

            // read the output from the server
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line = null;
            while ((line = reader.readLine()) != null) {
                //System.out.println("HttpUtil.consultarpaginaWeb ----> RPTA: "+line);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            // close the reader; this can throw an exception too, so
            // wrap it in another try/catch block.
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch (IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
        }
    }
}
