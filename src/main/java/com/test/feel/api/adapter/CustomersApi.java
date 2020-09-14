/**
 * 
 */
package com.test.feel.api.adapter;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.test.feel.domain.Customer;
import com.test.feel.domain.enums.Status;



/**
 * @author Christian Bernardino de Moura
 *
 * christianbmoura@gmail.com
 */
public interface CustomersApi {
	
	public ResponseEntity<List<Customer>> listCustomers(String name, String city, String productName, Status status);
	
	public ResponseEntity<Customer> findCustomerById(String id);
	
	public ResponseEntity<Customer> insertCustomer(Customer customer);
	
	public ResponseEntity<Customer> updateCustomer(String id, Customer customer);
	
	public ResponseEntity<Customer> patchCustomer(String id, Customer customer);
}
