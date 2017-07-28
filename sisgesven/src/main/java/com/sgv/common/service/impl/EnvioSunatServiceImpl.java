package com.sgv.common.service.impl;

import java.io.IOException;

import org.apache.ibatis.exceptions.PersistenceException;

import com.sgv.common.constants.Catalogo01SUNAT;
import com.sgv.common.exception.BusinessException;
import com.sgv.common.exception.DocumentoException;
import com.sgv.common.service.DocumentoService;
import com.sgv.common.service.EnvioSunatService;
import com.sgv.common.vo.DocumentoVO;
import com.sgv.fakturama.dao.DocumentDAO;
import com.sgv.fakturama.dao.impl.DocumentoDAOImpl;
import com.sgv.fakturama.dao.model.FktDocument;

public class EnvioSunatServiceImpl implements EnvioSunatService {


	public FktDocument enviarDocumentoSUNAT(DocumentoVO documento) throws BusinessException, PersistenceException, DocumentoException, IOException{

	    DocumentDAO dao = new DocumentoDAOImpl();
	    FktDocument result = dao.selectByNumero(documento);
	    
	    validarDocumento(result);
	    
	    DocumentoService service = obtenerDocumentoService(result);
	    service.generarDocumentoSUNAT(documento.getTipoOperacion());

	    return result;		
	}

	private void validarDocumento(FktDocument result) throws BusinessException {
		if(null == result) {
			System.err.println("EL DOCUMENTO NO EXISTE");
			throw new BusinessException("EL DOCUMENTO NO EXISTE");
		} else {
			//System.out.println("***** "+result.getContact());
			if((null == result.getItems() ) || 0 == result.getItems().size()) {
				System.err.println("EL DOCUMENTO NO TIENE ITEMS");
				throw new BusinessException("EL DOCUMENTO NO TIENE ITEMS");
			} else if (null == result.getContact() || null == result.getContact().getVATNUMBER() ){
				System.err.println("EL DOCUMENTO NO TIENE CONTACTO");
				throw new BusinessException("EL DOCUMENTO NO TIENE CONTACTO");
			}
		}		
	}

	private DocumentoService obtenerDocumentoService(FktDocument documento) throws BusinessException {
		DocumentoService service = null;
		switch (Catalogo01SUNAT.valueOf(documento.getDTYPE())) {
		case Invoice:
			service = new FacturaServiceImpl(documento);			
			System.out.println("El tipo de documento es Factura");
			break;
		case Credit:
			service = new NotaCreditoServiceImpl(documento);
			System.out.println("El tipo de documento es Nota de Credito");
			break;
		case Proforma:
			service = new BoletaServiceImpl(documento);
			System.out.println("El tipo de documento es Boleta");
			break;			
		default:
			System.out.println("No se identifico tipo de documento... :(");
			throw new BusinessException("NO SE IDENTIFICO EL TIPO DE DOCUMENTO.....");
		}
		
		return service;
	}
}
