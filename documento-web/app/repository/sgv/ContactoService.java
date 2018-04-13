package repository.sgv;

import commons.Constantes;
import controllers.dto.ContactoDTO;
import io.ebean.Expr;
import models.sgv.Contacto;

import java.util.List;

public class ContactoService extends SVGConnection{

    public static List<Contacto> obtenerListaContactos(ContactoDTO dto) throws Exception {
        System.out.println("************obtenerListaContactos "+dto);
        List<Contacto> lista = db.find(Contacto.class).select("")
                .where().or(
                        Expr.eq("codigo",dto.codigo),
                        Expr.eq("tipocontacto",dto.tipoContacto)
                )
                .findList();

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
        return lista;
    }

    public static void crearContacto(Contacto contacto) {
        contacto.tipoContacto.id.codigoPadre = Constantes.PARAMETRO_TIPO_CONTACTO;
        contacto.tipoPersona.id.codigoPadre = Constantes.PARAMETRO_TIPO_PERSONA;
        System.out.println("**************crearContacto - "+contacto);
        db.save(contacto);
    }

    public static Contacto obtenerPorId(Long id) {
        return db.find(Contacto.class).select("")
                .where().eq("id",id)
                .findOne();
    }
}
