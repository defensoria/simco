/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.comun.type;

/**
 *
 * @author carlos
 */

import gob.dp.simco.seguimiento.vo.SelectVO;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum MesesEnum {

	ENERO("01", "Enero"),

	FEBRERO("02", "Febrero"),
	
	MARZO("03", "Marzo"),
	
	ABRIL("04", "Abril"),
	
	MAYO("05", "Mayo"),
	
	JUNIO("06", "Junio"),
	
	JULIO("07", "Julio"),
	
	AGOSTO("08", "Agosto"),
	
	SEPTIEMBRE("09", "Septiembre"),
	
	OCTUBRE("10", "Octubre"),
	
	NOVIEMBRE("11", "Noviembre"),
	
	DICIEMBRE("12", "Diciembre");
	
	/** La Constante list. */
	private static final List<MesesEnum> list = new ArrayList<MesesEnum>();
	
	/** La Constante lookup. */
	private static final Map<String, MesesEnum> lookup = new HashMap<String, MesesEnum>();

	static {
		for (MesesEnum s : EnumSet.allOf(MesesEnum.class)) {
			list.add(s);
			lookup.put(s.getKey(), s);
		}

	}
	
	/** El key. */
	private String key;
	
	/** El value. */
	private String value;

	/**
	 * Instancia un nuevo tipo via type.
	 *
	 * @param key el key
	 * @param value el value
	 */
	private MesesEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * Obtiene key.
	 *
	 * @return Retorna un valor de tipo String para el key del tipo de via.
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Obtiene value.
	 *
	 * @return Retorna un valor de tipo String para el valor del tipo de via.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Obtiene description.
	 *
	 * @param locale Par&aacute;metro de tipo Locale que determina la localidad.
	 * @return Retorna un valor de tipo String con la descripci&oacute;n del
	 * tipo de via.
	 */
	public String getDescription() {
		return this.getValue();
	}

	/**
	 * Obtiene list.
	 *
	 * @param locale Par&aacute;metro de tipo Locale que determina la localidad.
	 * @return Retorna una lista de tipo SelectVO con el key y
	 * descripci&oacute;n del tipo de via.
	 */
	public static List<SelectVO> getList() {
		List<SelectVO> rList = new ArrayList<SelectVO>();
		for (MesesEnum s : list) {
			SelectVO select = new SelectVO();
			select.setId(s.getKey());
			select.setValue(s.getValue());
			rList.add(select);
		}
		return rList;
	}

	public static String verMes(String cod){
		String mes = "";
		if(cod.equalsIgnoreCase(ENERO.getKey()))
			mes = ENERO.getValue();
		if(cod.equalsIgnoreCase(FEBRERO.getKey()))
			mes = FEBRERO.getValue();
		if(cod.equalsIgnoreCase(MARZO.getKey()))
			mes = MARZO.getValue();
		if(cod.equalsIgnoreCase(ABRIL.getKey()))
			mes = ABRIL.getValue();
		if(cod.equalsIgnoreCase(MAYO.getKey()))
			mes = MAYO.getValue();
		if(cod.equalsIgnoreCase(JUNIO.getKey()))
			mes = JUNIO.getValue();
		if(cod.equalsIgnoreCase(JULIO.getKey()))
			mes = JULIO.getValue();
		if(cod.equalsIgnoreCase(AGOSTO.getKey()))
			mes = AGOSTO.getValue();
		if(cod.equalsIgnoreCase(SEPTIEMBRE.getKey()))
			mes = SEPTIEMBRE.getValue();
		if(cod.equalsIgnoreCase(OCTUBRE.getKey()))
			mes = OCTUBRE.getValue();
		if(cod.equalsIgnoreCase(NOVIEMBRE.getKey()))
			mes = NOVIEMBRE.getValue();
		if(cod.equalsIgnoreCase(DICIEMBRE.getKey()))
			mes = DICIEMBRE.getValue();
		
		return mes;
	}
        
        
        public static String verMes2(String cod){
		String mes = "";
		if(cod.equalsIgnoreCase(ENERO.getKey()))
			mes = "ENE";
		if(cod.equalsIgnoreCase(FEBRERO.getKey()))
			mes = "FEB";
		if(cod.equalsIgnoreCase(MARZO.getKey()))
			mes = "MAR";
		if(cod.equalsIgnoreCase(ABRIL.getKey()))
			mes = "ABR";
		if(cod.equalsIgnoreCase(MAYO.getKey()))
			mes = "MAY";
		if(cod.equalsIgnoreCase(JUNIO.getKey()))
			mes = "JUN";
		if(cod.equalsIgnoreCase(JULIO.getKey()))
			mes = "JUL";
		if(cod.equalsIgnoreCase(AGOSTO.getKey()))
			mes = "AGO";
		if(cod.equalsIgnoreCase(SEPTIEMBRE.getKey()))
			mes = "SEP";
		if(cod.equalsIgnoreCase(OCTUBRE.getKey()))
			mes = "OCT";
		if(cod.equalsIgnoreCase(NOVIEMBRE.getKey()))
			mes = "NOV";
		if(cod.equalsIgnoreCase(DICIEMBRE.getKey()))
			mes = "DIC";
		
		return mes;
	}
	/**
	 * 
	 * Metodo constructor del Enum TipoViaType con par&aacute;metro.
	 * 
	 * @param key
	 *            Par&aacute;metro de tipo String que determina el key del tipo
	 *            de via.
	 * @return void.
	 */
	public static MesesEnum get(String key) {
		return lookup.get(key);
	}
}
