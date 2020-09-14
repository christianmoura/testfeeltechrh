/**
 * 
 */
package com.test.feel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.feel.domain.Product;

/**
 * @author Christian Bernardino de Moura
 *
 * christiabmoura@gmail.com
 */
@Repository
public interface ProductRepository  extends JpaRepository<Product, String>  {

	List<Product> findByNameIgnoreCase(String productName);
	
}
