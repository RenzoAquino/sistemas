package com.sgv.common.constants;

public enum TypeOperationSUNAT {

	ALTA("01"), // Para crear documento Ej. Facturas, Boletas, Notas de Credito
	BAJA("02"); // Para anular documento Ej. Facturas, Boletas, Notas de Credito
	

    private final String text;

    /**
     * @param text
     */
    private TypeOperationSUNAT(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
    
    public static TypeOperationSUNAT getByName(String text){
        for (TypeOperationSUNAT e : TypeOperationSUNAT.values()) {
            if (e.text.equalsIgnoreCase(text)) {
              return e;
            }
          }
          return null;
    	//return   TypeDocument.valueOf(text);
    }
    
    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    /*
    @Override
    public String toString() {
        return text;
    }
    */
}
