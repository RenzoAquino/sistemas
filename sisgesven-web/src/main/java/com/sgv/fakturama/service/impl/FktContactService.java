package com.sgv.fakturama.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgv.fakturama.dao.domain.FktContact;
import com.sgv.fakturama.dao.mapper.FktContactMapper;


@Service
public class FktContactService {

    @Autowired
	private FktContactMapper mapper;
    
    public FktContact obtenerContacto(String ruc){    	
    	return mapper.obtenerContacto(ruc);
    }
    
}
