package repository;

import commons.Constantes;
import commons.TypeDocument_ES;
import controllers.dto.DocumentoDTO;
import models.Empresa;
import models.fakturama.FktContact;
import models.fakturama.FktDocument;
import models.fakturama.FktDocumentitem;
import models.fakturama.FktUserproperty;

import java.util.Map;

public class DocumentoService {

    public static FktDocument obtenerDatosDocumento(DocumentoDTO dto){
        FktDocument document = null;
        Map<String,FktUserproperty> mapUserproperty = null;
/*
        FktContact contact = FktContact.find.query().where().eq("vatnumber",dto.rucEmpresa).findOne();
        System.out.println(contact);
*/
/*
        document =
                Ebean.find(FktDocument.class)
                        .where().eq("name",document.NAME)
                        .findOne();
*/
        //Buscar UserProperty
        mapUserproperty = FktUserproperty.find.query()
                .where()
                .like("name","YOURCOMPANY_COMPANY_%")
                .setMapKey("NAME")
                .findMap();

        Empresa empresa = new Empresa();
        empresa.setRazonSocial(mapUserproperty.get(Constantes.YOURCOMPANY_COMPANY_NAME).t_VALUE);
        empresa.setEmail(mapUserproperty.get(Constantes.YOURCOMPANY_COMPANY_EMAIL).t_VALUE);
        empresa.setTelefono(mapUserproperty.get(Constantes.YOURCOMPANY_COMPANY_TEL).t_VALUE);
        empresa.setRuc(mapUserproperty.get(Constantes.YOURCOMPANY_COMPANY_VATNR).t_VALUE);

        //Buscar Documento
        document = FktDocument.find.query()
                //.fetch("contact" ).alias("c")
                //.fetch("fktdocumentitem")
                //.fetch("fktdocumentitem.vat")
                .where()
                .eq("name",dto.numero)
                .eq("dtype", TypeDocument_ES.valueOf(dto.tipoDocumento.id.codigo).getText())
                .findOne();
        document.contact = FktContact.find.byId(document.contact.ID);

        document.items = FktDocumentitem.find.query()
                .fetch("vat")
                .where()
                .eq("fk_document",document.ID)
                .orderBy().asc("t0.name")
                .findList();

        document.empresa = empresa;
        return document;
    }
}
