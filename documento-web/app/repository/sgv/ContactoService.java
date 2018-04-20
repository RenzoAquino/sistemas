package repository.sgv;

import commons.Constantes;
import commons.DatosSession;
import commons.util.GeneradorCodigoUtil;
import controllers.dto.ContactoDTO;
import io.ebean.Expr;
import io.ebean.Junction;
import io.ebean.Query;
import models.sgv.Contacto;

import java.util.List;

public class ContactoService extends SVGConnection{

    public static List<Contacto> obtenerListaContactos(ContactoDTO dto) throws Exception {
        System.out.println("ContactoService.obtenerListaContactos "+dto);
/*
        List<Contacto> lista = db.find(Contacto.class)
                .where()
                .eq("ruc", DatosSession.getInstance().ruc)
                .eq("tipocontacto_codigo",dto.tipoContacto)
                .findList();
*/
/*
        Query<Contacto> query = db.find(Contacto.class)
                .where()
                .conjunction()
                    .conjunction()
                        .eq("ruc", DatosSession.getInstance().ruc)
                        .eq("tipocontacto_codigo",dto.tipoContacto)
                    .endJunction()
                .endJunction()
                .or()
                    .disjunction()
                        .eq("codigo", dto.codigo)
                    .endJunction()
                    .disjunction()
                        .eq("numeroDocumento", dto.codigo)
                    .endJunction()
                    .disjunction()
                        .eq("tipoPersona_codigo", dto.tipoPersona)
                    .endJunction()
                .endJunction()
                .orderBy().asc("codigo");


        List<Contacto> lista  = query.findList();
        String sql = query.getGeneratedSql();
        System.out.println("ContactoService.obtenerListaContactos sql "+sql);
        System.out.println("ContactoService.obtenerListaContactos size "+lista.size());
*/
        Junction<Contacto> filters = db.find(Contacto.class).where().conjunction();

        filters
                .conjunction()
                .eq("ruc", DatosSession.getInstance().ruc)
                .eq("tipocontacto_codigo",dto.tipoContacto)
                .endJunction();

        if(dto.numero != null && !dto.numero.isEmpty()){
            filters
                    .conjunction()
                    .eq("numeroDocumento", dto.numero)
                    .endJunction();
        } else {
            if(dto.tipoPersona != null && !dto.tipoPersona.isEmpty() && !dto.tipoPersona.equals("0000")){
                filters
                        .conjunction()
                        .eq("tipoPersona_codigo", dto.tipoPersona)
                        .endJunction();
            }
        }


//        System.out.println("ContactoService.obtenerListaContactos sql 2 "+q.getGeneratedSql());

        List<Contacto> lista = filters.endJunction().findList();

        System.out.println("ContactoService.obtenerListaContactos size "+lista.size());

        return lista;

        /*
        ControlVenta libro = null;
        List<String> listaRetorno = new ArrayList<String>();



        String inicioDateTime = dto.anio.codigo + "-" + dto.mes.codigo + "-01 00:00:00";
        String finDateTime = dto.anio.codigo + "-" + dto.mes.codigo + "-31 23:59:59";

        // Format for input
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
// Parsing the date
        LocalDate inicioDate = LocalDate.parse(inicioDateTime, inputFormat);
        LocalDate finDate = LocalDate.parse(finDateTime, inputFormat);
// Format for output
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

// Printing the date
        System.out.println(inicioDate.format(outputFormat));
        System.out.println(finDate.format(outputFormat));

        String cabeceraSelect = "";
        List<String> listaIn = new ArrayList<String>();

        if (dto.tipoLibro.codigo.equals("LVEN")){
            cabeceraSelect = Constantes.SELECT_LIBRO_VENTA;
            listaIn.add("01");
            listaIn.add("03");
            listaIn.add("07");
            listaIn.add("08");
        } else if (dto.tipoLibro.codigo.equals("ANUL")){
            cabeceraSelect = Constantes.SELECT_ANULACIONES;
            listaIn.add("RA");
        }

        List<ControlVenta> lista = db.find(ControlVenta.class).select(cabeceraSelect)
                .where()
                .eq("CVNT_NUM_DOC_EMISOR", dto.razonSocial.codigo)
                .between("CVNT_FEC_EMI_DOCUMENTO", inicioDate.format(outputFormat), finDate.format(outputFormat))
                .in("CVNT_TIP_DOCUMENTO",listaIn)
                .findList();

        if(lista.size() == 0) {
            return listaRetorno;
        }

        if (dto.tipoLibro.codigo.equals("LVEN")){
            for (ControlVenta x : lista) {
                System.out.println("LVEN---"+x);
                listaRetorno.add(x.stringParaLibroVentasCSV(";"));
            }
        } else if (dto.tipoLibro.codigo.equals("ANUL")){
            for (ControlVenta x : lista) {
                System.out.println("ANUL---"+x);
                listaRetorno.add(x.stringParaAnulacionesCSV(";"));
            }
        }

        System.out.println("*********** size "+listaRetorno.size());
        */
        //return lista;
    }

    public static Contacto prepararDatos(Contacto contacto) {
        contacto.ruc = DatosSession.getInstance().ruc;
        contacto.tipoContacto.id.ruc =  DatosSession.getInstance().ruc;
        contacto.tipoContacto.id.codigoPadre = Constantes.PARAMETRO_TIPO_CONTACTO;
        contacto.tipoPersona.id.ruc =  DatosSession.getInstance().ruc;
        contacto.tipoPersona.id.codigoPadre = Constantes.PARAMETRO_TIPO_PERSONA;

        if(contacto.tipoPersona.id.codigo.equals(Constantes.PARAMETRO_CODIGO_TIPO_PERSONA_NATURAL)){
            contacto.razonSocial = null;
        } else if(contacto.tipoPersona.id.codigo.equals(Constantes.PARAMETRO_CODIGO_TIPO_PERSONA_NATURAL)){
            contacto.nombres = null;
            contacto.apellidoPaterno = null;
            contacto.apellidoMaterno = null;
        }
        System.out.println("ContactoService.prepararDatos :"+contacto);
        return contacto;
    }

    public static void crear(Contacto contacto) throws Exception {
        db.save(prepararDatos(contacto));

        GeneradorCodigoUtil.actualizarCodigoCliente(contacto.tipoContacto.id.codigo);
    }
    public static void eliminar(Contacto contacto) {
        System.out.println("**************eliminar - "+contacto);
        db.delete(contacto);
    }
    public static Contacto obtenerPorId(Long id) {
        return db.find(Contacto.class)
                .where().eq("id",id)
                .findOne();
    }

    public static void actualizar(Contacto contacto) {
        db.update(prepararDatos(contacto));
    }
}
