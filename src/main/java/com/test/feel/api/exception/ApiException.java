/**
 * 
 */
package com.test.feel.api.exception;

/**
 * @author Christian Bernardino de Moura
 *
 * christianbmoura@gmail.com
 */
public class ApiException extends Exception {
	private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
