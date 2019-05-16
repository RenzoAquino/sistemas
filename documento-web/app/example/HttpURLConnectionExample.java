package example;

import commons.Catalogo01SUNAT;
import commons.Constantes;
import commons.TypeDocument_ES;
import commons.util.HttpUtil;
import controllers.dto.DocumentoDTO;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class HttpURLConnectionExample {

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

        HttpURLConnectionExample http = new HttpURLConnectionExample();

        //System.out.println("Testing 1 - Send Http GET request");
        //http.sendGet();

        //System.out.println("\nTesting 2 - Send Http POST request Actualizar");
        //http.sendPostActualizar();
        System.out.println("\nTesting 3 - Send Http POST request GenerarXML");
        http.sendPostGenerarXML();

    }

    // HTTP GET request
    private void sendGet() throws Exception {

        String url = "http://localhost:9999 ";//http://www.google.com/search?q=mkyong";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

    // HTTP POST request
    private void sendPostActualizar() throws Exception {

        String url = "http://localhost:9999/api/ActualizarPantalla.htm";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        //HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "nomArch=20602885772-01-F001-00000014";//"sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }
    private void sendPostGenerarXML() throws Exception {

        String url = "http://localhost:9999/api/GenerarComprobante.htm";//"https://selfsolve.apple.com/wcResults.do";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        //HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);

        con.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        //con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        //String parameters = "num_ruc=20602885772&tip_docu=01&num_docu=F001-00000071";//
        String parameters = "{\"num_ruc\":\"20602885772\",\"tip_docu\":\"01\",\"num_docu\":\"F001-00000071\"}";

        // Send post request
        con.setDoOutput(true);
        con.setDoInput(true);
        OutputStream wr = con.getOutputStream();
        wr.write(parameters.getBytes("UTF-8"));
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + parameters);
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



}