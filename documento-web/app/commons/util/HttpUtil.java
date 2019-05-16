package commons.util;

import commons.Constantes;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

public class HttpUtil {

    private static final String USER_AGENT = "Mozilla/5.0";

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
    public static void enviarParametroJSONPaginaWeb(String direccionWeb, List<String> parametros, String tipoEnvio) throws Exception {
        BufferedReader reader = null;
        try {

            URL url = new URL(direccionWeb);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod(tipoEnvio);
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            //con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setDoOutput(true);
            con.setDoInput(true);

            OutputStream wr = con.getOutputStream();
            wr.write(String.join(Constantes.WEB_UNIR_PARAMETRO_JSON, parametros).getBytes("UTF-8"));
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + String.join(Constantes.WEB_UNIR_PARAMETRO_JSON, parametros));
            System.out.println("Response Code : " + responseCode);

            //System.out.println("getResponseMessage : " + con.getResponseMessage());
            //System.out.println("getErrorStream : " + con.getErrorStream());

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            System.out.println(response.toString());

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

            connection.setRequestProperty("User-Agent", USER_AGENT);
            /*
            // give it 15 seconds to respond
            //connection.setReadTimeout(15*1000);
            connection.connect();

            // read the output from the server
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line = null;
            while ((line = reader.readLine()) != null) {
                //System.out.println("HttpUtil.consultarpaginaWeb ----> RPTA: "+line);
            }
            */

            int responseCode = connection.getResponseCode();
            System.out.println("\nSending '"+tipoEnvio+"' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            /*
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            */
            in.close();

            //print result
            //System.out.println(response.toString());

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
