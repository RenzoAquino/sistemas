package com.sisint.common.resources.ws;

import com.google.common.base.MoreObjects;

public class FailResponse {
    private String cdigo;
    private String mensaje;

    public FailResponse() {
    }

    public FailResponse(String cdigo, String mensaje) {
        this.cdigo = cdigo;
        this.mensaje = mensaje;
    }

    public String getCdigo() {
        return cdigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("cdigo", cdigo)
                .add("mensaje", mensaje)
                .toString();
    }
}
