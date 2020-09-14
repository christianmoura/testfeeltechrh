/**
 * 
 */
package com.test.feel.factory;

import java.math.BigDecimal;


import com.test.feel.domain.Request;
import com.test.feel.domain.RequestCustomer;
import com.test.feel.domain.RequestProduct;

/**
 * @author Christian Bernardino de Moura
 *
 * christianbmoura@gmail.com
 */
public class CreateRequestFactoryTest {
	public static Request get(String id, RequestProduct product, RequestCustomer customer
			, Integer amount, BigDecimal value) {
		return new Request() {
			{
				setId(id);
				setProduct(product);
				setCustomer(customer);
				setAmount(amount);
				setValue(value);
			}
		};
	}
}
