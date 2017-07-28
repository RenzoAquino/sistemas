<html>
<head>
    <meta http-equiv="x-ua-compatible" content="IE=Edge"/>
    <meta charset="iso-8859-1"/>
    
    
        
	<title>Consolidador de Pedidos</title>
        
    
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
	if(tipoDocumento == "Nota Envío")document.getElementById("documentoTipo").value = "Nota_Envio";
    document.getElementById("myForm").submit();
}
</script>

</head>

<body>
<form method="post" action="/sisgesven/consolidadorPedido" id="myForm"  name="myForm">

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
			        <label for="clienteNombre" class="form__label"><b>Nombre de Cliente<sup>*</sup></b></label>
			    </span>
			    <span class="form__input-container">
			        <input maxlength="50" name="clienteNombre" id="clienteNombre" type="text" value="" class="jsvRequired input_text input_address idle form__input" readonly="readonly">
			    </span>
			</div>
			<div class="form__block jsAddressEditable">
			    <span class="form__label-container">
			        <label for="clienteRUC" class="form__label"><b>RUC de Cliente<sup>*</sup></b></label>
			    </span>
			    <span class="form__input-container">
			        <input maxlength="50" name="clienteRUC" id="clienteRUC" type="text" value="" class="input_text input_address idle form__input" readonly="readonly">
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
			        <label for="fechaInicio" class="form__label"><b>Fecha Inicio<sup>*</sup></b></label>
			    </span>
			    <span class="form__input-container">
			        <input maxlength="50" name="fechaInicio" id="fechaInicio" type="text" value="" class="input_text input_address idle form__input">
			    </span>
			</div>
			<div class="form__block jsAddressEditable">
			    <span class="form__label-container">
			        <label for="fechaFin" class="form__label"><b>Fecha Fin<sup>*</sup></b></label>
			    </span>
			    <span class="form__input-container">
			        <input maxlength="50" name="fechaFin" id="fechaFin" type="text" value="" class="input_text input_address idle form__input">
			    </span>
			</div>
			
			
			<div class="form__block jsAddressEditable">
			    <span class="form__label-container">
			        <label for="nroFactura01" class="form__label"><b>Nro. Factura 01<sup>*</sup></b></label>
			    </span>
			    <span class="form__input-container">
			        <input maxlength="50" name="nroFactura01" id="nroFactura01" type="text" value="PD01-00000066" class="input_text input_address idle form__input" readonly="readonly">
			    </span>
			</div>
			<div class="form__block jsAddressEditable">
			    <span class="form__label-container">
			        <label for="nroFactura02" class="form__label"><b>Nro. Factura 02<sup>*</sup></b></label>
			    </span>
			    <span class="form__input-container">
			        <input maxlength="50" name="nroFactura02" id="nroFactura02" type="text" value="PD01-00000067" class="input_text input_address idle form__input" readonly="readonly">
			    </span>
			</div>
			
			<div class="form__block jsAddressEditable">
			    <span class="form__label-container">
			        <label for="nroFactura03" class="form__label"><b>Nro. Factura 03<sup>*</sup></b></label>
			    </span>
			    <span class="form__input-container">
			        <input maxlength="50" name="nroFactura03" id="nroFactura03" type="text" value="PD01-00000068" class="input_text input_address idle form__input" readonly="readonly">
			    </span>
			</div>
			<div class="form__block jsAddressEditable">
			    <span class="form__label-container">
			        <label for="nroFactura04" class="form__label"><b>Nro. Factura 04<sup>*</sup></b></label>
			    </span>
			    <span class="form__input-container">
			        <input maxlength="50" name="nroFactura04" id="nroFactura04" type="text" value="PD01-00000069" class="input_text input_address idle form__input" readonly="readonly">
			    </span>
			</div>
	                                        
		    <div id="jsButton" class="form__block" style="display: block;">
				<a     href='#'  onclick="myFunction()"  class="actionbutton  actionbutton--yellow   actionbutton--right actionbutton--largeOnL actionbutton--full-width-onS">Envíar</a>
			</div>
	 	    </fieldset>
		</div>		
		
     </div>	
</div>

                                
</form>		
</body>
</html>