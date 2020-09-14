/**
 * 
 */
package com.test.feel.factory;


import com.test.feel.domain.RequestProduct;

/**
 * @author Christian Bernardino de Moura
 *
 * christianbmoura@gmail.com
 */
public class CreateRequestProductFatoryTest {
	public static RequestProduct get(String id, String name) {
		return new RequestProduct() {
			{
				setId(id);
				setName(name);
			}
		};
	}
}
