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

//https://www.jqueryscript.net/form/Input-Field-Data-Formatting-Plugin-Mask.html
$('#telefonoFijo').mask('999-9999');
$('#telefonoMovil').mask('999-999-999');



function ocultarContactoDatosTipoPersona() {
    $('#alias_field').hide();
    $('#numeroDocumento_field').hide();
    $('#nombres_field').hide();
    $('#apellidoPaterno_field').hide();
    $('#apellidoMaterno_field').hide();
    $('#razonSocial_field').hide();
}

$(document).ready(function() {
    //$('select').on('change', function() {
    //    alert( "xxx" + this.value );
    //})
    alert($('#tipoContacto.id.codigo' ).selected());
});

ocultarContactoDatosTipoPersona();

$('select').on('change', function() {
    if("tipoPersona.id.codigo" == this.name) {
        $('#alias').val("");
        $('#numeroDocumento').val("");
        $('#nombres').val("");
        $('#apellidoPaterno').val("");
        $('#apellidoMaterno').val("");
        $('#razonSocial').val("");



        if(this.value == "0000"){
            ocultarContactoDatosTipoPersona();
        } else if(this.value == "01"){
            $('#alias_field').show();
            $('#numeroDocumento_field').show();
            $('#nombres_field').show();
            $('#apellidoPaterno_field').show();
            $('#apellidoMaterno_field').show();
            $('#razonSocial_field').hide();
            $('#numeroDocumento').mask('99999999');
        } else if(this.value == "02"){
            $('#alias_field').show();
            $('#numeroDocumento_field').show();
            $('#nombres_field').hide();
            $('#apellidoPaterno_field').hide();
            $('#apellidoMaterno_field').hide();
            $('#razonSocial_field').show();
            $('#numeroDocumento').mask('99999999999');
        }

    }

})


$(document).ready(function() {
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
    // other stuff
});