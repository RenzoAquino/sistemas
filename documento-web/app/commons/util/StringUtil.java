package commons.util;

public class StringUtil {

    public static String completarTamanio(String valor, int tamanioMaximo,String valorCompletar, boolean completarLadoIzquierdo) throws Exception {
        StringBuilder stb = new StringBuilder();
        String tmp = "";
        int tamanioValor = valor.length();
        if(tamanioValor > tamanioMaximo){
            valor = valor.substring(0,tamanioMaximo);

            System.err.println("ERROR: El tamaño del número ["+valor+"] tamañoValor ["+tamanioValor+"] excede el maximo valor de ["+tamanioMaximo+"]");
            tamanioValor = valor.length();
            //throw new Exception("ERROR: El tama￱o del n￺mero ["+valor+"] excede el maximo valor de ["+tamanioMaximo+"]");
        }

        for(int x=0; x < (tamanioMaximo-tamanioValor); x++){
            stb.append(valorCompletar);
        }
        tmp = stb.toString();

        stb = new StringBuilder();
        stb.append(valor);
        stb.insert((completarLadoIzquierdo)?0:tamanioValor, tmp);
        return stb.toString();
    }

    public static String completarTamanioDecimal(String valor, int tamanioMaximo,String valorCompletar, boolean completarLadoIzquierdo) throws Exception {
        String part01 = valor.split("\\.")[0];
        String part02 = valor.split("\\.")[1];
        return part01.concat(".").concat(completarTamanio(part02,tamanioMaximo,valorCompletar,completarLadoIzquierdo));
    }
}
