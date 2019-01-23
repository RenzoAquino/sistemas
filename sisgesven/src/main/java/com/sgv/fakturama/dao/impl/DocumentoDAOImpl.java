package com.sgv.fakturama.dao.impl;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.sgv.common.core.GenericDAO;
import com.sgv.common.vo.ConsolidadorPedidoVO;
import com.sgv.common.vo.DocumentoVO;
import com.sgv.fakturama.dao.DocumentDAO;
import com.sgv.fakturama.dao.model.FktDocument;

public class DocumentoDAOImpl extends GenericDAO implements DocumentDAO{

    public DocumentoDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.sgv.fakturama.dao.impl.DocumentDAO#selectByNumero(com.sgv.common.vo.DocumentoVO)
	 */
   @Override
   public FktDocument selectByNumero(DocumentoVO documento) throws PersistenceException{
	    FktDocument document = null;
	    System.out.println("DocumentoDAOImpl.selectByNumero "+documento);
       	document = session.selectOne("com.sgv.fakturama.dao.FktDocumentMapper.selectByNumero", documento );
        return document;
    }
   @Override
   public FktDocument selectByNumeroBasico(DocumentoVO documento) throws PersistenceException{
	    FktDocument document = null;
	    System.out.println("DocumentoDAOImpl.selectByNumeroBasico "+documento);
       	document = session.selectOne("com.sgv.fakturama.dao.FktDocumentMapper.selectByNumeroBasico", documento );
	   return document;
    } 
   
   @Override
   public FktDocument selectById(Long id)throws PersistenceException{
	    FktDocument document = null;
	    System.out.println("DocumentoDAOImpl.selectById "+id);
       	document = session.selectOne("com.sgv.fakturama.dao.FktDocumentMapper.selectById", id );
        return document;
    }

	@Override
	public List<FktDocument> obtenerPedidos(ConsolidadorPedidoVO vo) throws PersistenceException{
		List<FktDocument> result = null;
	    System.out.println("DocumentoDAOImpl.obtenerPedidos "+vo);
       	result = session.selectList("com.sgv.fakturama.dao.FktDocumentMapper.obtenerPedidos", vo );
		return result;
	}

	@Override
	public void resetearPedido(FktDocument fktDocument) throws PersistenceException{
		System.out.println("DocumentoDAOImpl.resetearPedido "+fktDocument);
		session.update("com.sgv.fakturama.dao.FktDocumentMapper.resetearPedido", fktDocument);		
	}
	@Override
	public void updateByPrimaryKey(FktDocument fktDocument)throws PersistenceException{
		System.out.println("DocumentoDAOImpl.updateByPrimaryKey "+fktDocument);
		session.update("com.sgv.fakturama.dao.FktDocumentMapper.updateByPrimaryKey", fktDocument);		
	}
	
}
