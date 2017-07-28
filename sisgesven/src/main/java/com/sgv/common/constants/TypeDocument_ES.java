package com.sgv.common.constants;

public enum TypeDocument_ES {

	Factura("Invoice"), //
	Credito("Credit"), //Nota de Credito
	Proforma("Proforma"), //Boleta
	Nota_Envio("Delivery"),//Nota de Envio
	Pedido("Order")//Pedido
	;
	

    private final String text;

    /**
     * @param text
     */
    private TypeDocument_ES(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
    
    public static TypeDocument_ES getByName(String text){
    	
    	for (TypeDocument_ES e : TypeDocument_ES.values()) {
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
