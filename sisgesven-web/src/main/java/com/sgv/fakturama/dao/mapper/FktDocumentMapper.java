package com.sgv.fakturama.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.exceptions.PersistenceException;

import com.sgv.core.dao.domain.Parametro;
import com.sgv.fakturama.dao.domain.FktDocument;

@Mapper
public interface FktDocumentMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktDocument record);

    int insertSelective(FktDocument record);

    FktDocument selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktDocument record);

    int updateByPrimaryKeyWithBLOBs(FktDocument record);

    int updateByPrimaryKey(FktDocument record);
    
    List<FktDocument> obtenerListaDocumentos(List<Parametro> list );
}