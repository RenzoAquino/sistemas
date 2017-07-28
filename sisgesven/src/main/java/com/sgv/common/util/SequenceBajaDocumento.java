package com.sgv.common.util;



import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Date;

import com.sgv.base.dao.RegistroFacturadorSunatDAO;
import com.sgv.base.dao.impl.RegistroFacturadorSunatDAOImp;
import com.sgv.common.constants.Constants;

public class SequenceBajaDocumento {

	private static Double sequence = 0.0;	
	private String date=""; 
	
	private static SequenceBajaDocumento instance = null;
	
	protected SequenceBajaDocumento() {
	}
	public static SequenceBajaDocumento getInstance() {
		if(instance == null) {
			instance = new SequenceBajaDocumento();						
		}		
		return instance;
	}
	
	public String getNextVal(){
		String toDay = DateUtil.formatDate(new Date(), Constants.FORMAT_DATE_YYYYMMDD);
		if(!toDay.equals(date)){	
			date = toDay;
			RegistroFacturadorSunatDAO dao = new RegistroFacturadorSunatDAOImp() ;
			Double tmp = dao.obtenerValorActualSecuencia();
			sequence = ((null == tmp)?0.0:tmp);
			
		}
		sequence =sequence+1;
		return convertDoubleToString(sequence);
	}
	
	private  String convertDoubleToString(Double numberAsString) {
		DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols();
		unusualSymbols.setDecimalSeparator('.');
    	DecimalFormat decimalFormat = new DecimalFormat("000",unusualSymbols);
    	decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
    	return decimalFormat.format(numberAsString);
	}
}
