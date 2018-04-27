package com.sisint.generador.resources;

import com.google.common.base.MoreObjects;
import com.sisint.common.util.ConvertUtil;
import com.sisint.fakturama.handler.FakturamaHandler;
import com.sisint.fakturama.models.FktDocument;
import com.sisint.sfs.handler.SFSHandler;

import java.io.IOException;

/**
 * Resource for the API.  This is a presentation class for frontend work.
 */
public class GeneradorResource {
    private String id;
    private String emisorRuc;
    private String documentoNumero;
    private String documentoTipo;
    private String tipoOperacion;

    private String nombreArchivo;
    private String link;

    public GeneradorResource() {
    }

    public GeneradorResource(String id, String emisorRuc, String documentoNumero, String documentoTipo, String tipoOperacion, String nombreArchivo, String link) {
        this.id = id;
        this.emisorRuc = emisorRuc;
        this.documentoNumero = documentoNumero;
        this.documentoTipo = documentoTipo;
        this.tipoOperacion = tipoOperacion;
        this.nombreArchivo = nombreArchivo;
        this.link = link;
    }

    public GeneradorResource(FktDocument data, String link) {
        System.out.print("GeneradorResource data = "+data);

        this.id = data.ID.toString();
        this.link = link;
        this.documentoNumero = data.NAME;
        this.documentoTipo = data.DTYPE;
        this.nombreArchivo = "20477954350-01-"+data.NAME;
    }


    public String getEmisorRuc() {
        return emisorRuc;
    }

    public String getDocumentoNumero() {
        return documentoNumero;
    }

    public String getDocumentoTipo() {
        return documentoTipo;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public String getEquivalenciaDocumentoTipo() {
        String newValue = documentoTipo;
        try {
            newValue =  ConvertUtil.convertListMapaToMap(FakturamaHandler.obtenerListaTipoDocumento()).get(documentoTipo);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return newValue;
        }

    }

    public String getEquivalenciaTipoOperacion() {
        String newValue = tipoOperacion;
        try {
            newValue =  ConvertUtil.convertListMapaToMap(SFSHandler.obtenerListaOperacion()).get(tipoOperacion);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return newValue;
        }
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("emisorRuc", emisorRuc)
                .add("documentoNumero", documentoNumero)
                .add("documentoTipo", documentoTipo)
                .add("tipoOperacion", tipoOperacion)
                .add("nombreArchivo", nombreArchivo)
                .add("link", link)
                .toString();
    }
}
