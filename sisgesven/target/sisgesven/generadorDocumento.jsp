<html>
<head>
    <meta http-equiv="x-ua-compatible" content="IE=Edge"/>
    <meta charset="iso-8859-1"/>
    
    
        
	<title>Generador de Archivos - SFS</title>
        
    
    <meta name="robots" content="index, follow" />
    <meta name="description" content="Päckchen und Pakete online frankieren und bezahlen. Die Abholung kann einfach dazugebucht werden." />
    <meta name="keywords" content="[]" lang="de" />
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />
    <meta name="msapplication-TileColor" content="#fc0">
    <meta name="msapplication-square150x150logo" content="/square.png">
    <meta name="msapplication-config" content="none"/>
    <meta name="theme-color" content="#ffe67f"/>
    <link rel="shortcut icon" href="/favicon.ico"/>
    <link rel="apple-touch-icon" href="/apple-touch-icon.png"/>
    
    <link rel="stylesheet" href="/sisgesven/styles/vendor.css"/>
    <link rel="stylesheet" href="/sisgesven/styles/main.css"/>
    

<script>
function myFunction() {
	
	var tipoDocumento = document.getElementById("documentoTipo").value;
	if(tipoDocumento == "Crédito")document.getElementById("documentoTipo").value = "Credito";
    document.getElementById("myForm").submit();
}
</script>

</head>

<body>
<form method="post" action="/sisgesven/enviarDocumentoSUNAT" id="myForm"  name="myForm">

<input name="company.ruc" type="hidden" value="">
	
<div class="stripe stripe--color-gray">
	<div class="row">                                
		<div class="col col--nomb x12">
	        <h2 class="headline headline--level1">Envío de Documento a SUNAT</h2>
	        <p class="text">Se debera de ingresar el número de documento <br>(Ej. Factura, Boleta, Nota de Credito) a ser envíado a la SUNAT.</p>
	    </div>
		<div class="col x6" id="jsPickupAddress">
		    <fieldset title="Envío de Documento a SUNAT" class="typeahead">

			<div class="form__block jsAddressEditable">
			    <span class="form__label-container">
			        <label for="emisorNombre" class="form__label"><b>Nombre de Emisor<sup>*</sup></b></label>
			    </span>
			    <span class="form__input-container">
			        <input maxlength="50" name="emisorNombre" id="emisorNombre" type="text" value="" class="jsvRequired input_text input_address idle form__input" readonly="readonly">
			    </span>
			</div>
			<div class="form__block jsAddressEditable">
			    <span class="form__label-container">
			        <label for="emisorRUC" class="form__label"><b>RUC de Emisor<sup>*</sup></b></label>
			    </span>
			    <span class="form__input-container">
			        <input maxlength="50" name="emisorRUC" id="emisorRUC" type="text" value="" class="input_text input_address idle form__input" readonly="readonly">
			    </span>
			</div>
			<div class="form__block jsAddressEditable">
			    <span class="form__label-container">
			        <label for="documentoTipo" class="form__label"><b>Tipo de Documento<sup>*</sup></b></label>
			    </span>
			    <span class="form__input-container">
			        <input maxlength="50" name="documentoTipo" id="documentoTipo" type="text" value="" class="input_text input_address idle form__input" readonly="readonly">
			    </span>
			</div>
			<div class="form__block jsAddressEditable">
			    <span class="form__label-container">
			        <label for="numeroDocumento" class="form__label"><b>Número de Documento<sup>*</sup></b></label>
			    </span>
			    <span class="form__input-container">
			        <input maxlength="50" name="documentoNumero" id="documentoNumero" type="text" value="" class="input_text input_address idle form__input" readonly="readonly">
			    </span>
			</div>
	                                        
	 	    </fieldset>
		</div>
		
		
		<div class="col col--nomb x12">
	        <h4 class="headline headline--level1">Tipo de Operación</h4>
	        <p class="text">Definir tipo de operación que se va hacer en SUNAT.</p>
	    </div>
		
		<div class="col x6">
	        <table class="table">
	            <tr class="table__tr">
	                <td class="table__td table__td--text-left">
	                    <input name="radTipoOperacion" checked id="paReturn" type="radio" class="form__radio" value="ALTA">
	                    <label for="paReturn" class="form__label form__label--radio form__label--nomb">
	                        <span id="jspaReturn">Crear documento</span>
	                    </label>
						<span class="tooltip tooltip--pt" role="button" title="Crea el documento en SUNAT">
						</span>
                  </td>
              </tr>
              <tr class="table__tr">
                  <td class="table__td table__td--text-left">
                      <input name="radTipoOperacion" id="paDestroy" type="radio" class="form__radio" value="BAJA">
                      <label for="paDestroy" class="form__label form__label--radio form__label--nomb">
                          <span id="jspaReturn">Anular documento</span>
                      </label>                                 
					<span class="tooltip tooltip--pt" role="button" title="Anula el documento en SUNAT">
					</span>

                 </td>
             </tr>
             <tr class="table__tr">
                  <td class="table__td table__td--text-left">
				    <div id="jsButton" class="form__block" style="display: block;">
						<a     href='#'  onclick="myFunction()"  class="actionbutton  actionbutton--yellow   actionbutton--right actionbutton--largeOnL actionbutton--full-width-onS">Envíar</a>
					</div>

                 </td>
             </tr>
         </table>
     </div>
     </div>	
</div>

                                
</form>		
</body>
</html>