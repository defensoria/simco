/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.registro.type;

/**
 *
 * @author carlos
 */

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum MesEnum {

	ENE("01", "ENE"),

	FEB("02", "FEB"),
	
	MAR("03", "MAR"),
	
	ABR("04", "ABR"),
	
	MAY("05", "MAY"),
	
	JUN("06", "JUN"),
	
	JUL("07", "JUL"),
	
	AGO("08", "AGO"),
	
	SEP("09", "SEP"),
	
	OCT("10", "OCT"),
	
	NOV("11", "NOV"),
	
	DIC("12", "DIC");
	
	/** La Constante list. */
	private static final List<MesEnum> list = new ArrayList<>();
	
	/** La Constante lookup. */
	private static final Map<String, MesEnum> lookup = new HashMap<>();

	static {
		for (MesEnum s : EnumSet.allOf(MesEnum.class)) {
			list.add(s);
			lookup.put(s.getKey(), s);
		}

	}
	
	/** El key. */
	private final String key;
	
	/** El value. */
	private final String value;

	/**
	 * Instancia un nuevo tipo via type.
	 *
	 * @param key el key
	 * @param value el value
	 */
	private MesEnum(String key, String value) {
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

	public String getDescription() {
		return this.getValue();
	}

	public static String verMes(String cod){
		String mes = "";
		if(cod.equalsIgnoreCase(ENE.getKey()))
			mes = ENE.getValue();
		if(cod.equalsIgnoreCase(FEB.getKey()))
			mes = FEB.getValue();
		if(cod.equalsIgnoreCase(MAR.getKey()))
			mes = MAR.getValue();
		if(cod.equalsIgnoreCase(ABR.getKey()))
			mes = ABR.getValue();
		if(cod.equalsIgnoreCase(MAY.getKey()))
			mes = MAY.getValue();
		if(cod.equalsIgnoreCase(JUN.getKey()))
			mes = JUN.getValue();
		if(cod.equalsIgnoreCase(JUL.getKey()))
			mes = JUL.getValue();
		if(cod.equalsIgnoreCase(AGO.getKey()))
			mes = AGO.getValue();
		if(cod.equalsIgnoreCase(SEP.getKey()))
			mes = SEP.getValue();
		if(cod.equalsIgnoreCase(OCT.getKey()))
			mes = OCT.getValue();
		if(cod.equalsIgnoreCase(NOV.getKey()))
			mes = NOV.getValue();
		if(cod.equalsIgnoreCase(DIC.getKey()))
			mes = DIC.getValue();
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
	public static MesEnum get(String key) {
		return lookup.get(key);
	}
}
