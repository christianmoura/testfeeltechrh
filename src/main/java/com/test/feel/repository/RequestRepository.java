/**
 * 
 */
package com.test.feel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.feel.domain.Request;

/**
 * @author Christian Bernardino de Moura
 *
 * christianbmoura@gmail.com
 */
public interface RequestRepository   extends JpaRepository<Request, String>  {

	List<Request> findByCustomerName(String customerName);
	
	List<Request> findByProductName(String productName);
	
}
