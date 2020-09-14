/**
 * 
 */
package com.test.feel.factory;

import com.test.feel.domain.Address;



/**
 * @author Christian Bernardino de Moura
 *
 * christiabmoura@gmail.com
 */
public class CreateAddressFactoryTest {
	public static Address get(String id, String street, String neighborhood
			, String city, String province) {
		return new Address() {
			{
				setId(id);
				setStreet(street);
				setNeighborhood(neighborhood);
				setCity(city);
				setProvince(province);
			}
		};
	}
}
