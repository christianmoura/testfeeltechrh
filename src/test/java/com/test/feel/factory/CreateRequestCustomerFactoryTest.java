/**
 * 
 */
package com.test.feel.factory;


import com.test.feel.domain.RequestCustomer;

/**
 * @author Christian Bernardino de Moura
 *
 * christianbmoura@gmail.com
 */
public class CreateRequestCustomerFactoryTest {

	public static RequestCustomer get(String id, String name) {
		return new RequestCustomer() {
			{
				setId(id);
				setName(name);
			}
		};
	}
	
}
