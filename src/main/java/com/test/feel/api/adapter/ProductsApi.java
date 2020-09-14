/**
 * 
 */
package com.test.feel.api.adapter;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.test.feel.api.exception.NotFoundException;
import com.test.feel.domain.Product;

/**
 * @author Christian Bernardino de Moura
 *
 * christianbmoura@gmail.com
 */

public interface ProductsApi {

	public ResponseEntity<List<Product>> listProducts();
	
	public ResponseEntity<Product> findProductById(String id);
	
	public ResponseEntity<Void> insertProduct(Product product);
	
	public ResponseEntity<Void> deleteProduct(String id)  throws NotFoundException ;
	
}
