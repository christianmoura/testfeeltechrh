/**
 * 
 */
package com.test.feel.factory;

import java.util.List;


import com.test.feel.domain.Address;
import com.test.feel.domain.Customer;
import com.test.feel.domain.Request;
import com.test.feel.domain.enums.Status;

/**
 * @author Christian Bernardino de Moura
 *
 * christianbmoura@gmail.com
 */
public class CreateCustomerFactoryTest {
	public static Customer get(String id, String name, Address address
			, List<Request> requests, Status status) {
		return new Customer() {
			{
				setId(id);
				setName(name);
				setAddress(address);
				setRequests(requests);
				setStatus(status);
			}
		};
	}
}
