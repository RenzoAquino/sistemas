package commons.util;

import commons.Catalogo01SUNAT;
import commons.Constantes;
import commons.TypeDocument_ES;
import controllers.dto.DocumentoDTO;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class SFSUtil {

    public static String obtenerHashSUNAT(DocumentoDTO dto) throws SAXException, ParserConfigurationException, IOException, XPathExpressionException {
        // La expresion xpath de busqueda
        //String xPathExpression = "/Invoice/UBLExtensions/UBLExtension/ExtensionContent/Signature/SignedInfo/Reference/DigestValue";//"//DigestValue";
        //String nombreArchivo = dto.rucEmpresa;
        //System.out.println("TipoDcoumento : "+dto.tipoDocumento);

        String  tipoDocumento = Catalogo01SUNAT.valueOf(TypeDocument_ES.valueOf(dto.tipoDocumento.id.codigo).getText()).getText();
        String nombreArchivo = dto.rucEmpresa.concat("-"+tipoDocumento+"-").concat(dto.numero).concat(Constantes.EXTENSION_XML);
/*
        if(dto.tipoDocumento.id.codigo.equals("Factura")){
            nombreArchivo = nombreArchivo.concat("-01-").concat(dto.numero).concat(Constantes.EXTENSION_XML);
        } else if(dto.tipoDocumento.id.codigo.equals("Proforma")){
            nombreArchivo = nombreArchivo.concat("-03-").concat(dto.numero).concat(Constantes.EXTENSION_XML);
        }
*/
        nombreArchivo = Constantes.RUTA_XML_FIRMADO_SFS.concat(nombreArchivo);

        System.out.println("*******nombreArchivo["+nombreArchivo+"]");

        // Carga del documento xml
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //RUTA_XML_FIRMADO_SFS
        Document documento = builder.parse(new File(nombreArchivo));

        // Preparación de xpath
        XPath xpath = XPathFactory.newInstance().newXPath();

        // Consultas
        NodeList nodos = (NodeList) xpath.evaluate(Constantes.XPATH_XML_FIRMADO_HASH_SFS, documento, XPathConstants.NODESET);

        return getString2(nodos);

    }
    protected static String getString2(NodeList list) {
        if (list != null && list.getLength() > 0) {
            NodeList subList = list.item(0).getChildNodes();

            if (subList != null && subList.getLength() > 0) {
                return subList.item(0).getNodeValue();
            }
        }

        return null;
    }

}
