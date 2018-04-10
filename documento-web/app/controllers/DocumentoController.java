package controllers;

import commons.util.ticket.GenerarTicketDetallado;
import commons.util.ticket.GenerarTicketResumido;
import commons.util.ImpresoraUtil;
import commons.util.PDFUtil;
import controllers.dto.DocumentoDTO;
import models.Documento;
import models.fakturama.FktDocument;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import repository.DocumentoService;
import views.html.documento.*;
import views.html.errors.*;

import javax.inject.Inject;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.awt.print.PrinterException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class DocumentoController extends Controller{

    @Inject
    FormFactory formFactory;

    // para todos los documentos
    public Result index(){
        //Set<Documento> documentos = Documento.obtenerTodos();
        List<Documento> documentos = Documento.find.all();//obtenerTodos();
        return ok(index.render(documentos));
    }

    // para crear
    public Result crear(){
        Form<Documento> documentoForm = formFactory.form(Documento.class);
        return ok(crear.render(documentoForm));
    }

    // para guardar
    public Result guardar(){
        Form<Documento> documentoForm = formFactory.form(Documento.class).bindFromRequest();
        if(documentoForm.hasErrors()){
            flash("danger","Por favor corregir los errores del formulario");
            return badRequest(crear.render(documentoForm));
        }

        Documento documento = documentoForm.get();
        documento.save();
        flash("success","Se creo correctamente el documento.");
        //Documento.guardar(documento);

        return redirect(routes.DocumentoController.index());
    }
    public Result editar(Long id){
        Documento documento = Documento.find.byId(id);//Documento.buscarPorId(id);
        if(documento==null)
            return notFound(_404.render());

        Form<Documento> documentoForm = formFactory.form(Documento.class).fill(documento);

        return ok(editar.render(documentoForm));
    }
    public Result actualizar(){

        Form<Documento> documentoForm = formFactory.form(Documento.class).bindFromRequest();
        if(documentoForm.hasErrors()){
            flash("danger","Por favor corregir los errores del formulario");
            return badRequest(editar.render(documentoForm));
        }

        Documento documento = documentoForm.get();
        Documento oldDocumento = Documento.find.byId(documento.id);
        if(oldDocumento==null) {
            flash("danger", "Documento no encontrado");
            return notFound();
        }
        oldDocumento.name = documento.name;
        oldDocumento.typeDocumento = documento.typeDocumento;
        oldDocumento.igv = documento.igv;
        oldDocumento.menssage1 = documento.menssage1;
        oldDocumento.menssage2 = documento.menssage2;
        oldDocumento.menssage3 = documento.menssage3;
        oldDocumento.update();

        flash("success","Se actualizo correctamente el documento.");

        return ok();
        //return redirect(routes.DocumentoController.index());
    }
    public Result eliminar(Long id){
        Documento documento = Documento.find.byId(id);
        if(documento==null) {
            flash("danger", "Documento no encontrado");
            return notFound();
        }
        documento.delete();//Documento.eliminar(documento);

        flash("success","Se elimino correctamente el documento.");

        return ok();//redirect(routes.DocumentoController.index());
    }

    // para el detalle
    public Result ver(Long id){
        Documento documento = Documento.find.byId(id);
        if(documento == null)
            return notFound(_404.render());

        return ok(ver.render(documento));
    }

    public Result verImprimirTicket() throws Exception {
        String myUrl = "http://localhost:8090/FacturadorSunat/index.htm";
        // if your url can contain weird characters you will want to
        // encode it here, something like this:
        // myUrl = URLEncoder.encode(myUrl, "UTF-8");
        //doHttpSendDataUrlConnection();
        //String results = registrarDocumentosDbSUNAT(myUrl);
        //System.out.println("************"+results);

        //generarDocumentoXMLSUNAT();
        //enviarDocumentoXmlSUNAT();
        //generarDocumentoPdfSUNAT();
        //generarDocumentoPdfSUNAT();
        //obtenerHashSUNAT();

        DocumentoDTO dto = new DocumentoDTO();
        dto.tipoDetalle ="R";
        dto.listaTipoAccion = new ArrayList<String>();
        dto.listaTipoAccion.add("IMP");

        Form<DocumentoDTO> documentoDTOForm = formFactory.form(DocumentoDTO.class).fill(dto);

        return ok(verImprimirTicket.render(documentoDTOForm));
    }

    // para generarTicket
    public Result imprimirTicket() throws Exception {

        Form<DocumentoDTO> documentoDTOForm = formFactory.form(DocumentoDTO.class).bindFromRequest();
        if(documentoDTOForm.hasErrors()){
            flash("danger","Por favor corregir los errores del formulario");
            return badRequest(verImprimirTicket.render(documentoDTOForm));
        }

        if(documentoDTOForm.get().listaTipoAccion == null){
            flash("danger","Por favor seleccionar si va imprimir y/o generar un pdf");
            return badRequest(verImprimirTicket.render(documentoDTOForm));
        }

        //Invocar Generador de Archivos TXT

        //Invocar registro de Documento - SFS

        //Generar XML de Documento - SFS

        //Obtener valor hashSUNAT - SFS

        //Actualizar campo comentario 3(HASH) de Documento - FAKTURAMA


        DocumentoDTO dto = documentoDTOForm.get();
        System.out.println(dto);
        FktDocument document = DocumentoService.obtenerDatosDocumento(dto);
        System.out.println(document);

        GenerarTicketResumido impR= new GenerarTicketResumido(document);
        GenerarTicketDetallado impD = new GenerarTicketDetallado(document);

        try {
            if(dto.tipoDetalle.equals("D")){
                impD.generarTicket();
            }
            else if(dto.tipoDetalle.equals("R")){
                impR.generarTicket();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ejecutarTipoAccion(dto.listaTipoAccion,document);



/*
        FktContact fktContact = FktContact.find.byId(document.contact.ID);
        System.out.println(fktContact);
*/
/*
        List<FktDocumentitem> items = FktDocumentitem.find.query()
                .fetch("vat")
                .where()
                .eq("fk_document",document.ID)
                .findList();
        for (FktDocumentitem item: items
             ) {
            System.out.println(item);
        }
*/

        //documentoDTO.generarTicket();

        flash("success","Se realizo correctamente la operación.");

        //return redirect(routes.DocumentoController.verImprimirTicket());
        return ok(verImprimirTicket.render(documentoDTOForm));
    }

    private void doHttpSendDataUrlConnection(){
        System.out.println("doHttpSendDataUrlConnection.inicio..");

        try {
            String urlParameters  = "hddNumRuc=20477954350&hddTipDoc=01&hddNumDoc=F002-00000214";
            byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
            int    postDataLength = postData.length;
            String request        = "http://localhost:8090/FacturadorSunat/generarXml.htm";
            URL    url            = new URL( request );
            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            conn.setDoOutput( true );
            conn.setInstanceFollowRedirects( false );
            conn.setRequestMethod( "GET" );
            conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty( "charset", "utf-8");
            conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
            conn.setUseCaches( false );
            try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
                wr.write( postData );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("doHttpSendDataUrlConnection.fin..");
    }

    public void obtenerHashSUNAT() throws Exception {
        // La expresion xpath de busqueda
        String xPathExpression = "/Invoice/UBLExtensions/UBLExtension/ExtensionContent/Signature/SignedInfo/Reference/DigestValue";//"//DigestValue";

        // Carga del documento xml
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document documento = builder.parse(new File("D:\\sunat_archivos\\sfs\\FIRMA\\20477954350-01-F002-00000214.xml"));

        // Preparación de xpath
        XPath xpath = XPathFactory.newInstance().newXPath();

        // Consultas
        NodeList nodos = (NodeList) xpath.evaluate(xPathExpression, documento, XPathConstants.NODESET);

        System.out.println("***********["+getString2(nodos)+"]");

    }
    protected String getString2(NodeList list) {
        if (list != null && list.getLength() > 0) {
            NodeList subList = list.item(0).getChildNodes();

            if (subList != null && subList.getLength() > 0) {
                return subList.item(0).getNodeValue();
            }
        }

        return null;
    }

    public  void generarDocumentoPdfSUNAT() {

        try {

            String url = "http://localhost:8090/FacturadorSunat/MostrarXml.htm";

            URL obj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
/*
            String userpass = "user" + ":" + "pass";
            String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes("UTF-8"));
            conn.setRequestProperty ("Authorization", basicAuth);
*/
            String data =  "{\"nomArch\":\"20477954350-01-F002-00000214\",\"sitArch\":\"04\"}";
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.write(data);
            out.close();

            new InputStreamReader(conn.getInputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public  void enviarDocumentoXmlSUNAT() throws Exception {
        URL url = new URL("http://localhost:8090/FacturadorSunat/enviarXML.htm");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

        writer.write("hddNumRuc=20477954350&hddTipDoc=01&hddNumDoc=F002-00000214");
        writer.flush();
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        writer.close();
        reader.close();

    }

    public  void generarDocumentoXmlSUNAT() throws Exception {
        URL url = new URL("http://localhost:8090/FacturadorSunat/generarXml.htm");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

        writer.write("hddNumRuc=20477954350&hddTipDoc=01&hddNumDoc=F002-00000214");
        writer.flush();
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        writer.close();
        reader.close();

    }

    private String registrarDocumentosDbSUNAT(String desiredUrl)
            throws Exception
    {
        URL url = null;
        BufferedReader reader = null;
        StringBuilder stringBuilder;

        try
        {
            // create the HttpURLConnection
            url = new URL(desiredUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // just want to do an HTTP GET here
            connection.setRequestMethod("GET");

            // uncomment this if you want to write output to this url
            //connection.setDoOutput(true);

            // give it 15 seconds to respond
            connection.setReadTimeout(15*1000);
            connection.connect();

            // read the output from the server
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            stringBuilder = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null)
            {
                stringBuilder.append(line + "\n");
            }
            return stringBuilder.toString();
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

    private void ejecutarTipoAccion(List<String> listaTipoAccion,FktDocument document) throws InterruptedException, PrinterException, IOException {
        for (String string: listaTipoAccion) {
            System.out.println(string);
            if(string.equals("IMP")) {
                ImpresoraUtil.enviarAImpresora();
            } else if(string.equals("PDF")) {
                PDFUtil.convertirTXTaPDF(document.NAME+"_"+document.contact.COMPANY+".pdf");
            }
        }
    }


}
