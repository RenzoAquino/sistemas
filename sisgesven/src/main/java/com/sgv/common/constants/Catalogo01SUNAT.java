package com.sgv.common.constants;

public enum Catalogo01SUNAT {

	Invoice("01"), //SUNAT:Factura
	Proforma("03"), //SUNAT:Boleta
	Credit("07"), //SUNAT:Nota de Credito
	Debit("08"), //SUNAT:Nota de Debito
	GuiaRemitente("09"), //SUNAT: guia Remitente
	Delivery("-01"), //Solo existe en FAKTURAMA
	Order("-02"), //Solo existe en FAKTURAMA
	Letter("-03"), //Solo existe en FAKTURAMA
	Offer("-04"), //Solo existe en FAKTURAMA
	Dunning("-05"); //Solo existe en FAKTURAMA
	
	
    private final String text;

    /**
     * @param text
     */
    private Catalogo01SUNAT(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
    
    public static Catalogo01SUNAT getByName(String text){
        for (Catalogo01SUNAT e : Catalogo01SUNAT.values()) {
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
