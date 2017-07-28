package com.sgv.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.exceptions.PersistenceException;

import com.sgv.common.service.EnvioSunatService;
import com.sgv.common.service.impl.EnvioSunatServiceImpl;
import com.sgv.common.util.DBSessionUtil;
import com.sgv.common.vo.DocumentoVO;

public class EnviarDocumentoSUNATServlet extends HttpServlet {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
 	
@Override
  public void doGet(HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }

  @Override
  public void doPost(HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
	  
	  DocumentoVO documento = new DocumentoVO();
	  EnvioSunatService service = new EnvioSunatServiceImpl();
	  
	  String emisorRUC = request.getParameter("emisorRUC");
	  String documentoTipo = request.getParameter("documentoTipo");
	  String documentoNumero = request.getParameter("documentoNumero");
	  String tipoOperacion = request.getParameter("radTipoOperacion");
	  documento.setEmisorRUC(emisorRUC);
	  documento.setDocumentoTipo(documentoTipo);
	  documento.setDocumentoNumero(documentoNumero);
	  documento.setTipoOperacion(tipoOperacion);
	  documento.traducirVariablesFakturamaASUNAT();

	  
	  System.out.println("SERVLET "+documento);
    PrintWriter out = response.getWriter();
    try {
		out.println("Respuesta del proceso : "+service.enviarDocumentoSUNAT(documento).getRespuesta());
		DBSessionUtil.commit();
	} catch (PersistenceException e) {
		DBSessionUtil.rollback();
		out.println("ERROR CON LA DB  ["+e.getMessage()+"]");
		e.printStackTrace();
	} catch (Exception e) {
		DBSessionUtil.rollback();
		out.println("Respuesta del proceso : "+e.getMessage());
		e.printStackTrace();
	}  finally {
		//DBSessionUtil.close();	
	    out.flush();
	    out.close();
	}    
    //Buscar Documento en la DB
  }

@Override
public void destroy() {
	DBSessionUtil.close();	
	super.destroy();
}

@Override
public void init() throws ServletException {
	DBSessionUtil.create();
	super.init();
}
}