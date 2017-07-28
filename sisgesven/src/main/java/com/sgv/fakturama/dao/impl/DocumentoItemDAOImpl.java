package com.sgv.fakturama.dao.impl;

import org.apache.ibatis.exceptions.PersistenceException;

import com.sgv.common.core.GenericDAO;
import com.sgv.fakturama.dao.DocumentoItemDAO;
import com.sgv.fakturama.dao.model.FktDocumentitem;

public class DocumentoItemDAOImpl extends GenericDAO implements DocumentoItemDAO {

    public DocumentoItemDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}



   /* (non-Javadoc)
 * @see com.sgv.fakturama.dao.impl.DocumentoItemDAO#insertSelective(com.sgv.fakturama.dao.model.FktDocumentitem)
 */
@Override
public int insertSelective(FktDocumentitem item) throws PersistenceException{
	    int result = 0;
	    System.out.println("DAO "+item);
	    result = session.insert("com.sgv.fakturama.dao.FktDocumentitemMapper.insertSelective", item );
        return result;
    } 

   /* (non-Javadoc)
 * @see com.sgv.fakturama.dao.impl.DocumentoItemDAO#deleteByFKProduct(java.lang.Long)
 */
@Override
public int deleteByFKDocument(Long id)throws PersistenceException{
	    int result = 0;
	    System.out.println("DocumentoItemDAOImpl.deleteByFKDocument "+id);
	    result = session.delete("com.sgv.fakturama.dao.FktDocumentitemMapper.deleteByFKDocument", id );
        return result;
    }
	
}
