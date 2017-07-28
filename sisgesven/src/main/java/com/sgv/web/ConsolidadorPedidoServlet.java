package com.sgv.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.exceptions.PersistenceException;

import com.sgv.common.constants.TypeDocument_ES;
import com.sgv.common.service.ConsolidadorPedidoService;
import com.sgv.common.service.impl.ConsolidadorPedidoServiceImpl;
import com.sgv.common.util.DBSessionUtil;
import com.sgv.common.vo.ConsolidadorPedidoVO;

public class ConsolidadorPedidoServlet extends HttpServlet {
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
	  
	  ConsolidadorPedidoVO vo = new ConsolidadorPedidoVO();
	  ConsolidadorPedidoService service = new ConsolidadorPedidoServiceImpl();
	  
	  String emisorRUC = request.getParameter("emisorRUC");
	  String clienteNombre = request.getParameter("clienteNombre");
	  String clienteRUC = request.getParameter("clienteRUC");
	  String fechaInicio = request.getParameter("fechaInicio");
	  String fechaFin = request.getParameter("fechaFin");
	  String tipoDocumento = request.getParameter("documentoTipo");
	  	  
	  vo.getListaNumeroDocumento().add(request.getParameter("nroFactura01"));
	  vo.getListaNumeroDocumento().add(request.getParameter("nroFactura02"));
	  vo.getListaNumeroDocumento().add(request.getParameter("nroFactura03"));
	  vo.getListaNumeroDocumento().add(request.getParameter("nroFactura04"));
	  
	  vo.setEmisorRUC(emisorRUC);
	  vo.setClienteRUC(clienteRUC);
	  vo.setClienteNombre(clienteNombre);
	  vo.setFechaInicio(fechaInicio);
	  vo.setFechaFin(fechaFin);
	  vo.setTipoDocumento(TypeDocument_ES.valueOf(tipoDocumento).getText());
	  //vo.setTipoDocumento(Constants.FAKTURAMA_TIPO_DOCUMENTO_ORDER);
	  	  
	  System.out.println("SERVLET "+vo);
    PrintWriter out = response.getWriter();
    try {
		out.println("Respuesta del proceso : "+service.consolidarPedido(vo).getRespuesta());
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