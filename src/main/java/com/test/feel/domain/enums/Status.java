/**
 * 
 */
package com.test.feel.domain.enums;

/**
 * @author Christian Bernardino de Moura
 *
 * christiabmoura@gmail.com
 */
public enum Status {
	On, Off;
	
	public String getStatus() {
		
		String out = null;
		
		switch(this) {
		case On:
				out = "On";
		case Off:
				out = "Off";
		}
		
		return out;
	}
}
