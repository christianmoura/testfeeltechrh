/**
 * 
 */
package com.test.feel.api.exception;

/**
 * @author Christian Bernardino de Moura
 *
 * christianbmoura@gmail.com
 */
public class NotFoundException extends ApiException  {
	private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
