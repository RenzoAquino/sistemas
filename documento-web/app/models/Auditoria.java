package models;

import io.ebean.Model;

import java.sql.Timestamp;

public class Auditoria extends Model{

    //protected Long id;
    //protected String codigo;
    protected String usuarioCreacionRegistro;
    protected String usuarioModificacionRegistro;
    protected Timestamp fechaCreacionRegistro;
    protected Timestamp fechaModificacionRegistro;
    protected Character estadoRegistro; //E: Eliminado,C: Creado
}
