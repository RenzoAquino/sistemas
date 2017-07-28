package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.model.FktInvoice;

public interface FktInvoiceMapper {
    int deleteByPrimaryKey(Long INVOICE_PARENT_ID);

    int insert(FktInvoice record);

    int insertSelective(FktInvoice record);
}