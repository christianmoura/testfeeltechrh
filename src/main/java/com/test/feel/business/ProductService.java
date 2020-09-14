/**
 * 
 */
package com.test.feel.business;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.feel.api.adapter.ProductsApi;
import com.test.feel.api.exception.NotFoundException;
import com.test.feel.domain.Product;
import com.test.feel.repository.ProductRepository;

/**
 * @author Christian Bernardino de Moura
 *
 * christiabmoura@gmail.com
 */

@Service
public class ProductService implements ProductsApi {

	@Autowired
	private ProductRepository repository;
	
	private HttpServletRequest request;
	
	public ResponseEntity<List<Product>> listProducts(){
		String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            
        	return new ResponseEntity<List<Product>>(repository.findAll(),HttpStatus.OK);
        }

        return new ResponseEntity<List<Product>>(HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<Product> findProductById(String id) {
		String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
          
        	return new ResponseEntity<Product>(repository.getOne(id), HttpStatus.OK);
        }

        return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<Void> insertProduct(Product product) {
		 
		String accept = request.getHeader("Accept");
         if (accept != null && accept.contains("application/json")) {
        	 repository.save(product);
        	return new ResponseEntity<Void>(HttpStatus.OK); 
         }

        return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	public ResponseEntity<Void> deleteProduct(String id) throws NotFoundException {
		String accept = request.getHeader("Accept");
		Product del = repository.getOne(id);
		
		if (del != null) {
			repository.delete(del);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			throw new NotFoundException(404, "Not found");
		}
		
	}
}
