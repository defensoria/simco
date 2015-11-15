/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.seguimiento.type;

import gob.dp.simco.seguimiento.vo.SelectVO1;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum DiasProximosType {

	PROXIMOS_7(7, "Proximos 7 dias"),

	PROXIMOS_6(6, "Proximos 6 dias"),
        
        PROXIMOS_5(5, "Proximos 5 dias"),
        
        PROXIMOS_4(4, "Proximos 4 dias"),
        
        PROXIMOS_3(3, "Proximos 3 dias"),
        
        PROXIMOS_2(2, "Proximos 2 dias"),
        
        PROXIMOS_1(1, "Proximos 1 dias");
        
        
	
	
	/** La Constante list. */
	private static final List<DiasProximosType> list = new ArrayList<>();
	
	/** La Constante lookup. */
	private static final Map<String, DiasProximosType> lookup = new HashMap<>();

	static {
		for (DiasProximosType s : EnumSet.allOf(DiasProximosType.class)) {
			list.add(s);
			lookup.put(s.getKey().toString(), s);
		}
	}
	
	/** El key. */
	private final Integer key;
	
	/** El value. */
	private final String value;
	

	/**
	 * Instancia un nuevo tipo via type.
	 *
	 * @param key el key
	 * @param value el value
	 */
	private DiasProximosType(Integer key, String value) {
		this.key = key;
		this.value = value;
	}
        
        public static List<SelectVO1> getList() {
		List<SelectVO1> rList = new ArrayList<>();
		for (DiasProximosType s : list) {
			SelectVO1 select = new SelectVO1();
			select.setId(s.getKey());
			select.setValue(s.getValue());
			rList.add(select);
		}
		return rList;
	}

	/**
	 * Obtiene key.
	 *
	 * @return Retorna un valor de tipo String para el key del tipo de via.
	 */
	public Integer getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
	
	public String getDescription() {
		return this.getValue();
	}

	public static DiasProximosType get(String key) {
		return lookup.get(key);
	}
}
