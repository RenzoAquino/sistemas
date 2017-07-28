package com.sgv.common.constants;

public enum TypeAction {

	Create("01"), 
	Update("02"),
	Error("99");
	

    private final String text;

    /**
     * @param text
     */
    private TypeAction(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
    
    public static TypeAction getByName(String text){
        for (TypeAction e : TypeAction.values()) {
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
