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
    alert($('#tipoContacto.codigo' ).selected());
});

ocultarContactoDatosTipoPersona();

$('select').on('change', function() {
    if("tipoPersona.codigo" == this.name) {
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