/**
 * 
 */
package com.test.feel.factory;

import java.math.BigDecimal;

import com.test.feel.domain.Product;

/**
 * @author Christian Bernardino de Moura
 *
 * christianbmoura@gmail.com
 */
public class CreateProductFactoryTest {
	public static Product get(String id, String name, BigDecimal value) {
		return new Product() {
			{
				setId(id);
				setName(name);
				setValue(value);
			}
		};
	}
	
}
