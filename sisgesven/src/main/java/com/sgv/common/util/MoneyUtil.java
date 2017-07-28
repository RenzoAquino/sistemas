package com.sgv.common.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

public class MoneyUtil {

	public static void main(String[] args){
		Double numero = 2.54+0.46;
		System.out.println(convertirNumeroAPalabra(numero, false));
	}
	
	public static String convertirNumeroAPalabra(Double numero, boolean centimosEnLetra){
		System.out.println("convertirNumeroAPalabra - numero["+numero+"]");
		String moneda; 
		String monedas; 
		String centimo; 
		String centimos;
		String preposicion;
		String letra = ""; 
		Long numCentimos;
		Double MAXIMO = 1999999999.99;

		//************************************************************
		// Parámetros
		//************************************************************
		moneda = "Sol";          //Nombre de Moneda (Singular)
		monedas = "Soles";       //Nombre de Moneda (Plural)
		centimo = "Centavo";     //Nombre de Céntimos (Singular)
		centimos = "Centavos";   //Nombre de Céntimos (Plural)
		preposicion = "Con";     //Preposición entre Moneda y Céntimos
		//************************************************************
		
		
		
		//Validar que el Numero está dentro de los límites
		if ((numero >= 0) && (numero <= MAXIMO)) {

		    String doubleAsText = convertDoubleToString(numero);//numero;
		    //Double number = Double.parseDouble(doubleAsText);
		    //long decimal = Integer.parseInt(doubleAsText.split("\\.")[0]);
		    String sDecimal = (((doubleAsText.split("\\.")[1]).length() == 1)?(doubleAsText.split("\\.")[1])+"0":(doubleAsText.split("\\.")[1]));
		    //String sFractional = "0."+doubleAsText.split("\\.")[1];		    
		    numCentimos = new Long(sDecimal);//(long)(convertStringToDouble(sFractional)*100);
		    //System.out.println("Decimal - sFractional["+(doubleAsText.split("\\.")[1])+"] - numCentimos["+numCentimos+"]");
		    
		    letra = NUMERORECURSIVO((numero).longValue());              //Convertir el Numero en letras

		    //Si Numero = 1 agregar leyenda Moneda (Singular)
		    //    If (Numero = 1) Then
		    //        Letra = Letra & " " & Moneda
		    //De lo contrario agregar leyenda Monedas (Plural)
			//    Else
			//        Letra = Letra & " " & Monedas
			//    End If
		    
		    
		    //numCentimos = Round((numero - (numero).longValue()) * 100);   //Obtener los centimos del Numero
		    //System.out.println("Numero ["+numero.toString()+"]");

		    //System.out.println("doubleAsText ["+doubleAsText+"] - sDecimal ["+sDecimal+"] -decimal["+(convertStringToDouble(sDecimal)*100)+"]");
		    //numCentimos = convertStringToDouble(doubleAsText.split("\\.")[1]).longValue();
		    //long fractional = convertStringToDouble(doubleAsText.split("\\.")[1]).longValue();
		    
		    
		    //Si NumCentimos es mayor a cero inicar la conversión
		    if (numCentimos >= 0) {
		        //'Si el parámetro CentimosEnLetra es VERDADERO obtener letras para los céntimos
		        if (centimosEnLetra){
		            letra = letra + " " + preposicion + " " + NUMERORECURSIVO((numCentimos));  //NUMERORECURSIVO(Fix(numCentimos)); //Convertir los céntimos en letra
		                
		            //Si NumCentimos = 1 agregar leyenda Centimos (Singular)
		            if (numCentimos == 1) {
		                letra = letra + " " + centimo;
		            //'De lo contrario agregar leyenda Centimos (Plural)
		            } else {
		                letra = letra + " " + centimos;
		            }
		         //De lo contrario mostrar los céntimos como número
		        } else {
		            if (numCentimos < 10) {
		                //Letra = Letra & " 0" & NumCentimos & "/100"
		                letra = letra + " " + preposicion + " " + "0" + numCentimos + "/100";
		            } else {
		                //Letra = Letra & " " & NumCentimos & "/100"
		                letra = letra + " " + preposicion + " " + "" + numCentimos + "/100";
		            }
		        }
		    }

		    //Si Numero = 1 agregar leyenda Moneda (Singular)
		    if (numero == 1) {
		        letra = letra + " " + moneda;
		    //'De lo contrario agregar leyenda Monedas (Plural)
		    } else {
		        letra = letra + " " + monedas;
		    }

		    //Regresar el resultado final de la conversión
		    //letra;

		} else {
		    //Si el Numero no está dentro de los límites, entivar un mensaje de error
		    letra = "ERROR: El número excede los límites.";
		}

		
		
		return letra;
	}
	
	public static String NUMERORECURSIVO(long numero){
		String resultado = "";

		//**************************************************
		// Nombre de los números
		//**************************************************
		String unidades[] = {"", "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez", "Once", "Doce", "Trece", "Catorce", "Quince", "Dieciséis", "Diecisiete", "Dieciocho", "Diecinueve", "Veinte", "Veintiuno", "Veintidos", "Veintitres", "Veinticuatro", "Veinticinco", "Veintiseis", "Veintisiete", "Veintiocho", "Veintinueve"};
		String decenas[] = {"", "Diez", "Veinte", "Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta", "Ochenta", "Noventa", "Cien"};
		String centenas[] = {"", "Ciento", "Doscientos", "Trescientos", "Cuatrocientos", "Quinientos", "Seiscientos", "Setecientos", "Ochocientos", "Novecientos"};
		//**************************************************
		//System.out.println("NUMERORECURSIVO ["+numero+"]");
		
		if(numero == 0){
			resultado = "Cero";
		} else if ((numero >=1) && (29 >= numero) ){
			resultado = unidades[(int) (numero)];
		} else if ((numero >=30) && (100 >= numero) ){
			resultado =  decenas[(int)(numero / 10)] + (((numero % 10) != 0)?" y "+NUMERORECURSIVO(numero%10):"");
		} else if ((numero >=101) && (999 >= numero) ){
			resultado = centenas[(int)(numero / 100)] + (((numero % 100) != 0)?" "+NUMERORECURSIVO(numero%100):"");//IIf(Numero Mod 100 <> 0, " " + NUMERORECURSIVO(Numero Mod 100), "");
		} else if ((numero >=1000) && (1999 >= numero) ){
			resultado = "Mil" + (((numero % 1000) != 0)?" y "+NUMERORECURSIVO(numero%1000):""); //IIf(Numero Mod 1000 <> 0, " " + NUMERORECURSIVO(Numero Mod 1000), "");
		} else if ((numero >=2000) && (999999 >= numero) ){
			resultado = NUMERORECURSIVO(numero / 1000) + " Mil" + (((numero % 1000) != 0)?" "+NUMERORECURSIVO(numero%1000):"");//IIf(Numero Mod 1000 <> 0, " " + NUMERORECURSIVO(Numero Mod 1000), "");
		} else if ((numero >=1000000) && (1999999 >= numero) ){
			resultado = "Un Millón" + (((numero % 1000000) != 0)?" y "+NUMERORECURSIVO(numero%1000000):"");//IIf(Numero Mod 1000000 <> 0, " " + NUMERORECURSIVO(Numero Mod 1000000), "");
		} else if ((numero >=2000000) && (1999999999 >= numero) ){
			resultado = NUMERORECURSIVO(numero / 1000000) + " Millones" + (((numero % 1000000) != 0)?" "+NUMERORECURSIVO(numero%1000000):"");//IIf(Numero Mod 1000000 <> 0, " " + NUMERORECURSIVO(Numero Mod 1000000), "");
		}
		
		return resultado;		
	}
	
	public static Double convertStringToDouble(String numberAsString){
		
		Double newDouble = Double.parseDouble(numberAsString);
		//System.out.println("convertStringToDouble - numberAsString["+numberAsString+"] - newDouble ["+newDouble+"]");
		//return new Double(numberAsString);
		return newDouble; 
		/*
		//String numberAsString = "153.25";
		System.out.println("convertStringToDouble ["+numberAsString+"]");
		DecimalFormat decimalFormat = new DecimalFormat("#");
		try {
			decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
		   double number = decimalFormat.parse(numberAsString).doubleValue();
		   
		   System.out.println("The number is: " + number);
		} catch (ParseException e) {
		   System.out.println(numberAsString + " is not a valid number.");
		}
		return 0.00;
		/*
		Double d1 = 0.00;
    	DecimalFormat decimalFormat = new DecimalFormat("#");
    	System.out.println("convertStringToDouble ["+numberAsString+"]");
    	try {
    		Double d = decimalFormat.parse(numberAsString).doubleValue();
    	   System.out.println("The number is: " + d);
    	} catch (ParseException e) {
    	   System.out.println(numberAsString + " is not a valid number.");
    	}
    	return d1;
    	*/
    	//*/
	}
	public static Double convertStringToDouble01(String stringToNumber){
		Double d1 = 0.00;
    	DecimalFormat decimalFormat = new DecimalFormat("#.00");
    	
    	try {
    		d1 = decimalFormat.parse(stringToNumber).doubleValue();
    	   //System.out.println("The number is: " + d1);
    	} catch (ParseException e) {
    	   System.out.println(stringToNumber + " is not a valid number.");
    	}
    	return d1;
	}
	
	public static String convertDoubleToString(Double numberAsString) {
		String result;
		DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols();
		unusualSymbols.setDecimalSeparator('.');
    	DecimalFormat decimalFormat = new DecimalFormat("#0.00",unusualSymbols);
    	decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
    	result = decimalFormat.format(numberAsString);
  	   //System.out.println("The number is: " + result);
    	return result;
    	//return result.replace(",", ".");
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	public static String sumar(String valor01, String valor02) {		
		Double val01 = MoneyUtil.convertStringToDouble(valor01);
		Double val02 = MoneyUtil.convertStringToDouble(valor02);
		Double suma = val01 + val02;
		String resultado = MoneyUtil.convertDoubleToString(suma).replace(",", "."); 
		//System.out.println("sumar-String: "+resultado+" = "+valor01+" + "+valor02);
		//System.out.println("sumar-Double: "+suma+" = "+val01+" + "+val02);
		return resultado;
	}
}
