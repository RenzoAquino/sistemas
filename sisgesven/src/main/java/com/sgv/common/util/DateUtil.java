package com.sgv.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sgv.common.constants.Constants;



public class DateUtil {
	public static String formatDate(String value){
		String reformattedStr = "";
		try {
            SimpleDateFormat fromUser = new SimpleDateFormat(Constants.FORMAT_DATE_DD_MMM_YYYY);
            SimpleDateFormat myFormat = new SimpleDateFormat(Constants.FORMAT_DATE_YYYY_MM_DD);
            
        	reformattedStr = myFormat.format(fromUser.parse(value));
        } catch (ParseException e) {
            e.printStackTrace();
        } 		
        	return reformattedStr;
	}
	
	public static String formatDate(Date value,String format){
		String reformattedStr = (new SimpleDateFormat(format)).format(value); 		
        return reformattedStr;
	}
	
	public static Date convertStringToDate(String value,String formatIn){
		Date date = null; 
		System.out.println("=====================> "+value);
		DateFormat format = new SimpleDateFormat(formatIn);//, Locale.ENGLISH);
		 try {
			date = format.parse(value);
		} catch (ParseException e) {
			e.printStackTrace();
		}		 		
        return date;
	}
}
