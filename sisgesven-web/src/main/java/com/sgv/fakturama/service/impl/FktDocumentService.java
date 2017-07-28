package com.sgv.fakturama.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgv.core.dao.domain.Parametro;
import com.sgv.fakturama.dao.domain.FktContact;
import com.sgv.fakturama.dao.domain.FktDocument;
import com.sgv.fakturama.dao.mapper.FktDocumentMapper;



@Service
public class FktDocumentService {

    @Autowired
	private FktDocumentMapper mapper;
    
    public List<FktDocument> obtenerListaDocumentos(List<Parametro> listaParametro){
    	return mapper.obtenerListaDocumentos(listaParametro);
    }
    
    public List<FktDocument> obtenerListaDocumentosLimpios(List<Parametro> listaParametro){
    	List<FktDocument> listIn = mapper.obtenerListaDocumentos(listaParametro);
    	List<FktDocument> listOut = new ArrayList<FktDocument>();
    	
    	for (FktDocument fktDocument : listIn) {    		
    		listOut.add(cargarDocumento(fktDocument));
		}
    	listIn.stream().forEach(System.out::println);
    	listOut.stream().forEach(System.out::println);
    	return listOut;
    }
    
    private FktDocument cargarDocumento(FktDocument documentoBase ) {
		// TODO Auto-generated method stub
		FktDocument fktDocument = new FktDocument();
		fktDocument.setID(documentoBase.getID());
		fktDocument.setNAME(documentoBase.getNAME());
		fktDocument.setDTYPE("Order");
		fktDocument.setADDRESSFIRSTLINE("");
		/*
		fktDocument.setADDRESSFIRSTLINE(documentoBase.getContact().getCOMPANY()
				.concat(", ")
				.concat(documentoBase.getContact().getNAME())
				.concat(" ")
				.concat(documentoBase.getContact().getFIRSTNAME()));
		*/
		fktDocument.setBILLINGTYPE(3);//3:Order, 0:Invoice
		fktDocument.setCONSULTANT("AUTOGENERADO");
		fktDocument.setCUSTOMERREF("--");
		fktDocument.setDELETED(false);
		fktDocument.setDEPOSIT(false);
		fktDocument.setDOCUMENTDATE(new Date());
		fktDocument.setDUEDAYS(0);
		fktDocument.setITEMSREBATE(0.0);
		fktDocument.setMESSAGE("");
		fktDocument.setMESSAGE2("");
		fktDocument.setMESSAGE3("");
		fktDocument.setMODIFIED(new Date());
		fktDocument.setMODIFIEDBY("AUTOGENERADO");
		fktDocument.setNETGROSS(2);//2:bruto, 1:neto
		fktDocument.setODTPATH("");
		fktDocument.setORDERDATE(new Date());
		fktDocument.setPAID(false);
		fktDocument.setPAIDVALUE(0.0);
		fktDocument.setPAYDATE(null);//*****
		fktDocument.setPDFPATH("");
		fktDocument.setPRINTTEMPLATE("");
		fktDocument.setPRINTED(false);
		fktDocument.setPROGRESS(0);
		fktDocument.setSERVICEDATE(new Date());
		fktDocument.setSHIPPINGAUTOVAT("SHIPPINGVATGROSS");
		fktDocument.setSHIPPINGVALUE(0.0);
		fktDocument.setTOTALVALUE(0.00);
		fktDocument.setTRANSACTIONID(null);
		fktDocument.setVALIDFROM(new Date());
		fktDocument.setVALIDTO(new Date());
		fktDocument.setWEBSHOPDATE(null);
		fktDocument.setWEBSHOPID("");
		fktDocument.setFK_INDIVIDUALINFO(fktDocument.getFK_INDIVIDUALINFO());
		fktDocument.setFK_CONTACT(null);
		fktDocument.setFK_DELIVERYCONTACT(null);
		fktDocument.setDOCUMENT_INVOICEREFERENCE(null);
		fktDocument.setFK_NOVATREF(null);
		fktDocument.setFK_PAYMENT(documentoBase.getFK_PAYMENT());
		fktDocument.setFK_SHIPPING(new Long(1));
		fktDocument.setFK_SRCDOCUMENT(null);
		fktDocument.setContact(new FktContact());
		
		return fktDocument;
	}

	public void updateByPrimaryKey(FktDocument fktDocument) {
		mapper.updateByPrimaryKey(fktDocument);		
	}
	public void updateByPrimaryKeyWithBLOBs(FktDocument fktDocument) {
		mapper.updateByPrimaryKeyWithBLOBs(fktDocument);		
	}

}
