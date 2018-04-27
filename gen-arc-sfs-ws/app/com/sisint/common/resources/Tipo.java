package com.sisint.common.resources;

import com.google.common.base.MoreObjects;

public class Tipo {
    protected String id;
    protected String nombre;

    public Tipo() {
    }

    public Tipo(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("nombre", nombre)
                .toString();
    }
}
