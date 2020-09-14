/**
 * 
 */
package com.test.feel.domain.enums;

/**
 * @author Christian Bernardino de Moura
 *
 * christiabmoura@gmail.com
 */
public enum ProvinceEnum {
	MG, SP, RJ;
	
	public String getProvince() {
		
		String out = null;
		
		switch(this) {
		case MG:
				out = "MG";
		case SP:
				out = "SP";
		case RJ:
				out = "RJ";
		
		}
		
		return out;
	}
}
