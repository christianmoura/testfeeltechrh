/**
 * 
 */
package com.test.feel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.feel.domain.Customer;
import com.test.feel.domain.enums.Status;


/**
 * @author Christian Bernardino de Moura
 *
 * christianbmoura@gmail.com
 */
public interface CustomerRepository extends JpaRepository<Customer, String>  {
	
	List<Customer> findByName(String name);
	
	List<Customer> findByAddressCity(String city);
	
	@Query(value="SELECT CUSTOMER.ID, CUSTOMER.NAME, CUSTOMER.STATUS, CUSTOMER.ADDRESS_ID FROM CUSTOMER INNER JOIN REQUESTCUSTOMER ON CUSTOMER.NAME = REQUESTCUSTOMER.NAME INNER JOIN REQUEST ON REQESTPRODUCT.ID = REQUEST.ID INNER JOIN PRODUCT ON PRODUCT.NAME = REQUESTPRODUCT.NAME = ?1", nativeQuery = true)
	List<Customer> findByProductName(String productName);
	
	List<Customer> findByStatus(Status status);
	
}
