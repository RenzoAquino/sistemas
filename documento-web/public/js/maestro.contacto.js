

//https://www.jqueryscript.net/form/Input-Field-Data-Formatting-Plugin-Mask.html
function cargaInicial(){
    //alert($('#fechaCreacionGrp input.form-control').val());

    $('#fechaCreacionGrp input').val($('#fechaCreacion').val());
    //$('#fechaCreacionGrp input.form-control').val = $('#fechaCreacion').val();

    $('#telefonoFijo').mask('999-9999');
    $('#telefonoMovil').mask('999-999-999');
}


function mostrarDatosTipoPersona() {
    var selTipoPerona = $("#tipoPersona_id_codigo");

    if(selTipoPerona.val() == "0000"){
        $('#alias_field').hide();
        $('#numeroDocumento_field').hide();
        $('#nombres_field').hide();
        $('#apellidoPaterno_field').hide();
        $('#apellidoMaterno_field').hide();
        $('#razonSocial_field').hide();
    } else if(selTipoPerona.val() == "01"){
        $('#alias_field').show();
        $('#numeroDocumento_field').show();
        $('#nombres_field').show();
        $('#apellidoPaterno_field').show();
        $('#apellidoMaterno_field').show();
        $('#razonSocial_field').hide();
        $('#numeroDocumento').mask('99999999');
    } else if(selTipoPerona.val() == "02"){
        $('#alias_field').show();
        $('#numeroDocumento_field').show();
        $('#nombres_field').hide();
        $('#apellidoPaterno_field').hide();
        $('#apellidoMaterno_field').hide();
        $('#razonSocial_field').show();
        $('#numeroDocumento').mask('99999999999');
    }

}

$(document).ready(function() {

    cargaInicial();
    mostrarDatosTipoPersona();

    $('#fechaCreacionGrp').datetimepicker({
        language:  'es',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });

    $('#dashboard-table').DataTable( {
        "language": {
            "sProcessing":     "Procesando...",
            "sLengthMenu":     "Mostrar _MENU_ registros",
            "sZeroRecords":    "No se encontraron resultados",
            "sEmptyTable":     "Ningún dato disponible en esta tabla",
            "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
            "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
            "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix":    "",
            "sSearch":         "Buscar:",
            "sUrl":            "",
            "sInfoThousands":  ",",
            "sLoadingRecords": "Cargando...",
            "oPaginate": {
                "sFirst":    "Primero",
                "sLast":     "Último",
                "sNext":     "Siguiente",
                "sPrevious": "Anterior"
            },
            "oAria": {
                "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            }
        }
    } );


    $('select').on('change', function() {
        if("tipoPersona.id.codigo" == this.name) {
            mostrarDatosTipoPersona();
        }
    });


    $("#btn_contacto_eliminar").click(function() {
        sendDeleteRequest(""+$('#urlEliminar').val(),""+$('#urlInicio').val());
    });

    $("#btn_contacto_actualizar").click(function() {
        //alert($(elem).closest('form').attr('name'));
        sendPutRequest("contactoActualizarForm", "" + $('#urlActualizar').val());
    });
});

function sendDeleteRequest(url, rUrl) {
    $.ajax({
        url: url,
        method: "DELETE",
        success: function () {
            window.location = rUrl;
            //window.location.replace(rUrl);
        },
        error: function () {
            window.location.reload();
        }
    });
}


function sendPutRequest(formId, rUrl) {
    var form = $('#'+formId);
    $.ajax({
        url: form.attr('action'),
        method: "PUT",
        data: form.serialize(),
        success: function () {
            window.location = rUrl;
            //window.location.replace(rUrl);
        },
        error: function () {
            window.location.reload();
        }
    });
}