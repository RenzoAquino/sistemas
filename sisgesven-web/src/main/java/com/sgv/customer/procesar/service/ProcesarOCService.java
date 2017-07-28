package com.sgv.customer.procesar.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfReader;
import com.sgv.common.constants.Constants;
import com.sgv.common.util.PDFUtil;
import com.sgv.core.service.ParametroService;
import com.sgv.customer.procesar.dao.domain.EquivalenciaProducto;
import com.sgv.customer.procesar.dto.Documento;
import com.sgv.customer.procesar.dto.Item;
import com.sgv.fakturama.dao.domain.FktContact;
import com.sgv.fakturama.dao.domain.FktDocument;
import com.sgv.fakturama.dao.domain.FktDocumentitem;
import com.sgv.fakturama.dao.domain.FktProduct;
import com.sgv.fakturama.service.impl.FktContactService;
import com.sgv.fakturama.service.impl.FktDocumentItemService;
import com.sgv.fakturama.service.impl.FktDocumentService;

@Service
public class ProcesarOCService {

    @Autowired
	private EquivalenciaProductoService equivalenciaProductoService;
    @Autowired
	private ParametroService parametroService;
    @Autowired
	private FktDocumentService documentoService;
    @Autowired
	private FktDocumentItemService documentoItemService;    
    @Autowired
	private FktContactService contactService;    
    
    public Map<String, Documento> mapDoc = new HashMap<String, Documento>();
    public static Map<String, List<EquivalenciaProducto>> mapEquivalencia = new HashMap<String, List<EquivalenciaProducto>>();
    List<FktDocument> listaDocumentoPedido;
	
	
	public String procesarOC(byte[] aByte) throws Exception {
		Documento documento = null;
	    String numero = null;
	    String rucEmisor = null;
	    List<Item> listaItems = null;
	    Item item = null;
	    boolean cargarProductos = false;
	    boolean cargarMontos = false;
	    boolean saltarLineas = false;

		//CLEAN MAP
	    mapDoc.clear();
		
		
		String result = "";
		PdfReader reader = PDFUtil.obternerPdfReader(aByte);
		result = reader.getNumberOfPages() + " (Paginas)";
		String[][] textoPDF = PDFUtil.obtenerTextoPDF(reader);
		Stream<String> stream2 = null;
		//Stream<String> emisores = null;
		Map<String, String> rucs =  new HashMap<String,String>();
		
		for (int i = 0; i < textoPDF.length; i++) {
			String[] aLinea = textoPDF[i];		
			/*
			stream2 = Stream.of(array);
			stream2.forEach(x -> System.out.println(x));
			*/
			
			for (int j=((saltarLineas)?24: 0); j < aLinea.length; j++) {
				String line = aLinea[j].trim();
				String prefijoOC = "ORDEN DE COMPRA L -";
				String prefijoRUCEmisor = "RUC ";
				
				//System.out.println("page "+i+" - linea "+j+" ["+line+"]");
				if(!cargarProductos){
					prefijoOC = "ORDEN DE COMPRA L -";
					if(line.toUpperCase().startsWith(prefijoOC)){						
						numero = aLinea[j].replace(prefijoOC, "").trim();				
						documento = obtenerDocumento(numero);
						listaItems = documento.getListaItems();
					} else if(line.toUpperCase().startsWith(prefijoRUCEmisor)){
						rucEmisor = aLinea[j].replace(prefijoRUCEmisor, "").trim();
						rucs.put(rucEmisor, rucEmisor);
						documento.getEmisor().setRuc(rucEmisor);
						documento.getReceptor().setRuc(Constants.EMPRESA_RUT);
					} else if(line.toUpperCase().startsWith("RUC:")){
						cargarProductos = true;
					}
				} else if(cargarProductos){			
					System.out.println(line);
					if(line.matches("^(\\d){1,2}(\\s).*")){
						//System.out.println("Procesar Producto");
						//String newLine = line.replaceFirst("^(\\d){1,2}(\\s)", "");
						String[] newALine= null;
						//System.out.println(newLine);
						StringJoiner sj = new StringJoiner(" ");
						String pattern = "\\s";
						//Create a Pattern object
					    Pattern r = Pattern.compile(pattern);
					    // Now create matcher object.

					    newALine = r.split(line);
					    int cantidad = newALine.length;
					    //System.out.println("cantidad "+cantidad+" - "+line);					    
					    if(5 < cantidad){
					    	//System.out.println("Cantidad de fragmentos ["+cantidad+"]");
					    	
					    	for (int k = 1; k < cantidad-4; k++) {
								//System.out.print(newALine[k]+" ");
								sj.add(newALine[k]);
							}
					    	/*
					    	System.out.println("Precio Total ["+newALine[cantidad-1]+"]");
					    	System.out.println("Cantidad ["+newALine[cantidad-2]+"]");
					    	System.out.println("UM ["+newALine[cantidad-3]+"]");
					    	System.out.println("Precio Unitario ["+newALine[cantidad-4]+"]");
					    	*/
					    	
				        	item = new Item();				        	
				        	item.setQUANTITY(new Double(newALine[cantidad-2]));//Cantidad
				        	item.setQUANTITYUNIT(newALine[cantidad-3]);//UnidadMedida
				        	item.setNAME(sj.toString().trim());//Nombre
				        	item.setPRICE(new Double(newALine[cantidad-4]));//Precio
				        	item.setPrecioTotalItem(new Double(newALine[cantidad-1]));
				        	item.setExisteEnDB(false);
				        	//System.out.println(item);
					    }
						
					} else if (line.matches("^[Obs\\.].*") || line.matches(".*[Obs\\.]$")){//(line.startsWith("Obs.")){
						//System.out.println("Procesar Obs.");
						item.setDESCRIPTION(line.replace("Obs.", "").trim());//Descripcion
						listaItems.add(item);
					} else {
						if(!cargarMontos && line.matches("(\\d).*")) {
							documento.setIgv(new Double(line.trim()));
							cargarMontos = true;
						} else if(cargarMontos){
							//System.out.println("Carga Total ["+line.trim()+"]");
							documento.setPrecioTotal(new Double(line.replace(",", "").trim()));
							cargarMontos = false;						
						}
						//*/
					}
					
					//listaItems.add(item);
				    documento.setListaItems(listaItems);
					
				    if(line.matches("^(Lugar de Entrega|Página).*")){
				    	//System.out.println("listaItems.size() "+listaItems.size());

				    	
						if (line.matches("^[Lugar de Entrega].*")) {
							documento.setLugarEntrega(line.replace("Lugar de Entrega:", ""));
							
				    		cargarProductos = false;
				    		//cargarMontos = false;				    		
				    		saltarLineas = false;
				    		System.out.println(documento);
				    		cargarDocumento(documento);
				    		break;
						} else {
							saltarLineas = true;
						}
				    	cargarDocumento(documento);
				    }
				}				
			}
		}
		System.out.println("******Cantidad OC :"+mapDoc.size());
		
		//CARGAR EQUIVALENCIAS
		//Obtener lista de Numero Pedidos
		//List<Parametro> listaNumeroPedidos = parametroService.obtenerListaNumeroPedidosReservados();
		//listaNumeroPedidos.forEach(System.out::print);		
		listaDocumentoPedido = documentoService.obtenerListaDocumentosLimpios(parametroService.obtenerListaNumeroPedidosReservados());
		mapEquivalencia = procesarOC(rucs);
		
		//System.out.println(mapEquivalencia);

		
		return result;
	}

	private Map<String,List<EquivalenciaProducto>> procesarOC(Map<String, String> rucs) {
		//Map<String, String> rucs;
		//Map<String,List<EquivalenciaProducto>> listaProductosEquivalentes;
		Map<String,Map<String,EquivalenciaProducto>> mapProductosEquivalentes;
		Map<String,FktContact> mapRazonSocial;
		Map<String,String> mapEquivalenica;
		//List<FktDocument> listaDocumentoPedido;
		
		
		//Obtener lista de Numero Pedidos
		//List<Parametro> listaNumeroPedidos = parametroService.obtenerListaNumeroPedidosReservados();
		//listaNumeroPedidos.forEach(System.out::print);		
		//listaDocumentoPedido = documentoService.obtenerListaDocumentosLimpios(parametroService.obtenerListaNumeroPedidosReservados());
		
		/*
		rucs = mapDoc.entrySet()
				.stream()
				.collect(Collectors.toMap(
						e -> e.getValue().getEmisor().getRuc(),
                        e -> e.getValue().getEmisor().getRuc(),
                        (key01, key02) -> {
                            System.out.println("duplicate key found!");
                            return key01;
                        }));
		*/
		System.out.println("");
		System.out.println("************ RUCs : "+rucs);
		
		mapRazonSocial = rucs.entrySet()
				 .stream()
				 .collect(Collectors.toMap(
									 	e -> e.getKey(), 
									 	e -> contactService.obtenerContacto(e.getValue())
									 	) 
						 );
		System.out.println("************ mapRazonSocial : "+mapRazonSocial);
		/* CONVERT MAP TO LIST
		List<String> rucs = mapDoc.entrySet()
				.stream()
				.map(e -> e.getValue().getEmisor().getRuc())
				.collect(Collectors.toList());
		*/
		mapProductosEquivalentes = rucs.entrySet()
				 .stream()
				 .collect(Collectors.toMap(
									 	e -> e.getKey(), 
									 	e -> equivalenciaProductoService.obtenerMapEquivalenciaProductos(e.getValue())
									 	)
						 );
		System.out.println("************ mapProductosEquivalentes : "+mapProductosEquivalentes);
		/*
		Map<String,String> mapPatronEquivalencia = 
		//System.out.println(" TEMPORAL : "+
												listaProductosEquivalentes.entrySet()
													.stream()
													.collect(Collectors.toMap(
																			e -> e.getKey(),
																			e -> ( e.getValue()
																					.stream()
																					.map(p -> p.getEquivalencia())
																					.collect(Collectors.joining("|", "(", ")")
																						)
																					)
																			)
															);
		
		System.out.println("mapPatronEquivalencia : "+mapPatronEquivalencia);
				*/
		//);
		/*
		List<EquivalenciaProducto> lista = result.get("20515469380");
		String cadena = lista.stream()
		.map(p -> p.getProducto().getNAME())
		.collect(Collectors.joining("|", "(", ")"));
		 
		System.out.println(cadena);
		*/
		
		/*
		mapDoc.entrySet()
		.stream()
		.map(listaOC -> listaOC.getValue().getListaItems().)
		.collect(Collectors.toMap(
				e -> e.getValue().getEmisor().getRuc(),
                e -> e.getValue().getEmisor().getRuc(),
                (key01, key02) -> {
                    System.out.println("duplicate key found!");
                    return key01;
                }));
		*/
		

		//System.out.println("************************************* "+mapDoc.getOrDefault("00003373", new Documento("00003373")));

		Map<String,List<FktDocument>> mapResult = mapDoc.entrySet()
		.stream()
		.collect(Collectors.toMap(
								oc -> oc.getKey(),
								listaOC -> ( cargarFktDocumento(listaOC.getValue(), mapProductosEquivalentes, mapRazonSocial)
										)
								)
				);
		System.out.println("************ mapResult : "+mapResult);
		
		mapResult.entrySet()
		.stream()
		.forEach(listaFktDocument -> listaFktDocument.getValue()
														.stream()
														.forEach(pedido -> registrarPedido(pedido)
				)
		);//********************************
		//*/
		/*
		Pattern p = Pattern.compile("name: '([^']*)'");
		lines.map(p::matcher)
		     .filter(Matcher::matches)
		     .findFirst()
		     .ifPresent(matcher -> System.out.println(matcher.group(1)));
		
		*/
		
		//Limpiar registro de FKTDocument
		limpiarListaPedidoSinUsar();
		
		return null;//listaProductosEquivalentes;
	}
	
    private void limpiarListaPedidoSinUsar() {
		// TODO Auto-generated method stub
		listaDocumentoPedido.forEach(fktDocument->{
	    	documentoService.updateByPrimaryKeyWithBLOBs(fktDocument);
	    	documentoItemService.deleteByFKDocument(fktDocument.getID());			
		});
	}

	private void registrarPedido(FktDocument fktDocument) {
		// Registrar pedido en DB
    	System.out.println(fktDocument);
    	//eliminar detalle
    	
    	//registrar
    	
    	//FktDocument tmp ;
    	//System.out.println("fktDocument : "+fktDocument);
//    	System.out.println("fktDocument NUMERO: "+fktDocument.getNAME());
//    	System.out.println("fktDocument items: "+fktDocument.getItems().size());
    	documentoService.updateByPrimaryKeyWithBLOBs(fktDocument);
    	documentoItemService.deleteByFKDocument(fktDocument.getID());
    	
    	int nPosition = 0;
		for (FktDocumentitem item : fktDocument.getItems()) {
			//System.out.println(item);
			//obtener peso *******************
			nPosition++;			
			item.setID(null);
			item.setPOSNR(nPosition);
			item.setFK_DOCUMENT(fktDocument.getID());
			item.setDESCRIPTION((item.getDESCRIPTION()==null)?"":item.getDESCRIPTION());
			item.setDATEADDED(new Date());
			item.setITEMREBATE(new Double(0));
			documentoItemService.insertSelective(item);
		}
		System.out.println("FACTURA USADA : "+fktDocument.getNAME());
	}

	private List<FktDocument> cargarFktDocumento(Documento documento, Map<String,Map<String,EquivalenciaProducto>> mapProductosEquivalentes, Map<String,FktContact> mapRazonSocial) {
	
		Map<String,EquivalenciaProducto> lista = mapProductosEquivalentes.get(documento.getEmisor().getRuc());

    	List<FktDocument> listaFktDocument = new ArrayList<>();
    	EquivalenciaProducto ep = null; 
    	FktProduct producto  = null;
    	List<FktDocumentitem> itemConIGV = new ArrayList<FktDocumentitem>();
    	List<FktDocumentitem> itemSinIGV = new ArrayList<FktDocumentitem>();
    	//FktDocumentitem documententItem = null;
    	
    	System.out.println("cargarFktDocumento.documento.getListaItems().size() : "+documento.getListaItems().size());
    	for (Item item : documento.getListaItems()) {
    		ep = lista.getOrDefault(item.getNAME(), new EquivalenciaProducto());
    		producto = ep.getProducto();
    		
    		//documententItem = item;
    		
    		if(producto != null) {
    			item.setITEMNUMBER(producto.getITEMNUMBER());
    			item.setNAME(producto.getNAME());
    			item.setQUANTITYUNIT(producto.getQUANTITYUNIT());
    			item.setPRICE(producto.getPRICE1());
    			item.setFK_VAT(producto.getVat().getID());
    			item.setVat(producto.getVat());
    			item.setFK_PRODUCT(producto.getID());
    			
    			if(ep.getPostFijo() != null){
    				if(!ep.getPostFijo().isEmpty())
    					item.setNAME(item.getNAME().concat(" - "+ep.getPostFijo()));
    			}
    			
    			if(item.getNAME().startsWith("DESCONTINUADO")){
    				item.setPRICE(new Double(0));
    			}
    			/*
    			documententItem.setITEMNUMBER(producto.getITEMNUMBER());
    			documententItem.setNAME(producto.getNAME());
    			documententItem.setQUANTITYUNIT(producto.getQUANTITYUNIT());
    			documententItem.setPRICE(producto.getPRICE1());
    			documententItem.setFK_VAT(producto.getVat().getID());
    			documententItem.setVat(producto.getVat());
    			documententItem.setFK_PRODUCT(producto.getID());
    			*/
    			if( ((int) (ep.getProducto().getVat().getTAXVALUE()*100) > 0)){
    				itemConIGV.add(item);
    				//itemConIGV.add(documententItem);
    			} else {
    				itemSinIGV.add(item);
    				//itemSinIGV.add(documententItem);
    			}
    		} else {
    			item.setNAME("ANALISAR_"+item.getNAME());
    			item.setFK_VAT(new Long(1));
    			//item.setPRICE(item.getPRICE());

    			/*
    			documententItem.setNAME("V_"+item.getNAME());
    			documententItem.setFK_VAT(new Long(1));
    			documententItem.setPRICE(item.getPRICE());
    			*/
    			itemSinIGV.add(item);
    			//itemSinIGV.add(documententItem);
    		}
    	}
    	System.out.println("itemConIGV size : "+itemConIGV.size());
    	itemConIGV.stream().forEach(System.out::println);
    	System.out.println("itemSinIGV size : "+itemSinIGV.size());
    	itemSinIGV.stream().forEach(System.out::println);
    	
    	try {
    		listaFktDocument = generarListaPedidos(documento, itemConIGV, itemSinIGV, mapRazonSocial.get(documento.getEmisor().getRuc()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
		return listaFktDocument;
	}

	private void cargarDocumento(Documento documento) {
    	mapDoc.put(documento.getNumero(), documento);
	}

	private Documento obtenerDocumento(String numero) {
    	Documento doc = mapDoc.get(numero);
		if(null == doc){
			return new Documento(numero);
		} else {
			return doc;
		}		
	}	
	
	private List<FktDocument> generarListaPedidos(Documento documentoBase, List<FktDocumentitem> itemConIGV, List<FktDocumentitem> itemSinIGV, FktContact contacto) throws Exception {
		//Declaración de Variables
		FktDocument documento = null;
		List<FktDocument> listaPedidos = new ArrayList<FktDocument>();
		List<FktDocumentitem> listaItemsTMP = null;
		List<FktDocumentitem> listaItems = new ArrayList<FktDocumentitem>();
		List<FktDocumentitem> listaItemsSIGV = itemSinIGV;
		List<FktDocumentitem> listaItemsCIGV = itemConIGV;

		String numeroPedido = null;
		int cantidadPedidos = 0;
		int cantidadPedidosConIGV = 0;
		int cantidadPedidosSinIGV = 0;
		int cantidadResiduo = 0;
		int cantidadResiduoConIGV = 0;
		int cantidadResiduoSinIGV = 0;
		int maximaCantidadRegistros = 34;
		int nPCI = 0;
		int nPSI = 0;
    	int registroInicial = 0;
    	int registroFinal = 0;
		
		//Calcular cantidad registros		
		nPCI = itemConIGV.size();
		nPSI = itemSinIGV.size();
		
		cantidadPedidosSinIGV = (nPSI/maximaCantidadRegistros)+((nPSI%maximaCantidadRegistros == 0)?0:1);
		cantidadPedidosConIGV = (nPCI/maximaCantidadRegistros)+((nPCI%maximaCantidadRegistros == 0)?0:1);
		cantidadPedidos = cantidadPedidosConIGV+cantidadPedidosSinIGV;
		
		if(cantidadPedidos > listaDocumentoPedido.size()){
			throw new Exception("SE REQUIEREN GENERAR "+(cantidadPedidos-listaDocumentoPedido.size())+"DOCUMENTO(S).");
		}
		
		cantidadResiduoSinIGV = nPSI%maximaCantidadRegistros;
		cantidadResiduoConIGV = nPCI%maximaCantidadRegistros;

		/*
		listaItemsSIGV = mProductoSinIGV.entrySet()
				.stream()
				//.sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
				//.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
				.map(e -> convertirConsolidadirProductoAFktDocumentItem(e.getValue()))
				.collect(Collectors.toList());			
		//Collections.sort(listaItemsSIGV, new FktDocumentitemComparator());
		
		listaItemsCIGV = mProductoConIGV.entrySet()
				.stream()
				//.sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
				//.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
				.map(e -> convertirConsolidadirProductoAFktDocumentItem(e.getValue()))
				.collect(Collectors.toList());
		//Collections.sort(listaItemsCIGV, new FktDocumentitemComparator());
		*/
		
		
		System.out.println("****listaDocumentoPedido inicio :"+listaDocumentoPedido.size());
		//Cargar Pedidos
		for (int i = 0; i < cantidadPedidosSinIGV; i++) {
			documento = cargarDocumento(listaDocumentoPedido.get(i), contacto, documentoBase);
			
	    	registroInicial = maximaCantidadRegistros*i;
	    	registroFinal = (maximaCantidadRegistros*(i+1));//-1;
	    	if(i+1 == cantidadPedidosSinIGV)registroFinal=registroInicial+cantidadResiduoSinIGV;//-1;
	    	
	    	System.out.println("RegIni["+registroInicial+"] - RegEnd["+registroFinal+"]");
	    	
	    	listaItemsTMP = listaItemsSIGV.subList(registroInicial, registroFinal);
	    	
	    	//System.out.println("==================="+documento);
			for (FktDocumentitem fktDocumentitem : listaItemsTMP) {
				System.out.println("==================="+fktDocumentitem.getNAME());
			}
	    	
						
			documento.setItems(listaItemsTMP);		
			
			listaPedidos.add(documento);
			
		}
		
		for (int i = 0; i < cantidadPedidosConIGV; i++) {	
			documento = cargarDocumento(listaDocumentoPedido.get(cantidadPedidosSinIGV+i), contacto, documentoBase);
			
	    	registroInicial = maximaCantidadRegistros*i;
	    	registroFinal = (maximaCantidadRegistros*(i+1));//-1;
	    	if(i+1 == cantidadPedidosConIGV)registroFinal=registroInicial+cantidadResiduoConIGV;//-1;
	    	
	    	System.out.println("RegIni["+registroInicial+"] - RegEnd["+registroFinal+"]");
	    	
	    	listaItemsTMP = listaItemsCIGV.subList(registroInicial, registroFinal);

	    	//System.out.println("==================="+documento);
			for (FktDocumentitem fktDocumentitem : listaItemsTMP) {
				System.out.println("==================="+fktDocumentitem.getNAME());
			}	    	
	    	
			documento.setItems(listaItemsTMP);		
			
			listaPedidos.add(documento);
			
		}

		
		listaDocumentoPedido = listaDocumentoPedido.subList(cantidadPedidosSinIGV + cantidadPedidosConIGV,listaDocumentoPedido.size());
		
		System.out.println("****listaDocumentoPedido fin :"+listaDocumentoPedido.size());
	
		
		return listaPedidos;
	}

	private FktDocument cargarDocumento(FktDocument fktDocument, FktContact contacto, Documento documento) {
		fktDocument.setCUSTOMERREF("OC "+documento.getNumero()+" - SALA "+documento.getLugarEntrega() );
		fktDocument.setMESSAGE("OC "+documento.getNumero());
		fktDocument.setFK_CONTACT(contacto.getID());
		fktDocument.setContact(contacto);
		fktDocument.setFK_DELIVERYCONTACT(contacto.getFK_ADDRESS());
		//fktDocument.setBILLINGTYPE(3);//TIPO PEDIDO/ORDER
		fktDocument.setFK_PAYMENT(4L);
		fktDocument.setDUEDAYS(30);
		fktDocument.setDATEADDED(new Date());
		fktDocument.setNETGROSS(1);//2:bruto,1:neto
		fktDocument.setFK_INDIVIDUALINFO(fktDocument.getID());
		fktDocument.setFK_SHIPPING(1L);
		fktDocument.setADDRESSFIRSTLINE(fktDocument.getCUSTOMERREF());
		return fktDocument;
	}
}
