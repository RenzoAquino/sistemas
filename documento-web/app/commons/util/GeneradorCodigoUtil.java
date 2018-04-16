package commons.util;

import commons.Constantes;
import commons.DatosSession;
import models.sgv.Secuencia;
import repository.sgv.SecuenciaService;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeneradorCodigoUtil {

    public static String obtenerCodigo(Secuencia sec) throws Exception {
        if(sec == null || sec.valor.isEmpty()) return "";

        System.out.println("**********************obtenerCodigo : formato ["+sec+"]");

        Pattern patron = Pattern.compile("(<\\w*>)");
        Matcher matcher = patron.matcher(sec.valor);

        String seqPatron = "";
// Hace que Matcher busque los trozos.
        while (matcher.find()) {
            seqPatron = matcher.group();
        }
        String num = seqPatron.replace("n","").replace("<","").replace(">","");
        BigInteger siguienteValor = sec.secuencia.add(new BigInteger("1"));
        String sNuevoValor = siguienteValor.toString();
        String x =  StringUtil.completarTamanio(sNuevoValor,Integer.parseInt(num),"0",true);
        sec.secuencia = siguienteValor;
        DatosSession.getInstance().putSecuencia(sec);

        return sec.valor.replace(seqPatron,x);
    }

    public static String generarCodigoCliente(String tipo) throws Exception {
        Secuencia obj = null;
        if(Constantes.PARAMETRO_CODIGO_FORMATO_CLIENTE.equals(tipo)){
            obj = SecuenciaService.obtenerFormatoCliente();
        } else if(Constantes.PARAMETRO_CODIGO_FORMATO_PROVEEDOR.equals(tipo)){
            obj = SecuenciaService.obtenerFormatoProveedor();
        }
        System.out.println("**********************generarCodigoCliente - "+obj);
        return obtenerCodigo(obj);
    }

    public static void actualizarCodigoCliente(String tipo) throws Exception {
        Secuencia obj = null;
        if(Constantes.PARAMETRO_CODIGO_FORMATO_CLIENTE.equals(tipo)){
            obj = SecuenciaService.obtenerFormatoCliente();
        } else if(Constantes.PARAMETRO_CODIGO_FORMATO_PROVEEDOR.equals(tipo)){
            obj = SecuenciaService.obtenerFormatoProveedor();
        }
        obj = DatosSession.getInstance().getSecuencia(obj.id.toString());
        SecuenciaService.actualizar(obj);
        System.out.println("**********************generarCodigoCliente - "+obj);
    }
}
