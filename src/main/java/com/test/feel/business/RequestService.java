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
import org.springframework.util.StringUtils;

import com.test.feel.api.adapter.RequestsApi;
import com.test.feel.domain.Request;

import com.test.feel.repository.RequestRepository;

/**
 * @author Christian Bernardino de Moura
 *
 * christianbmoura@gmail.com
 */

@Service
public class RequestService implements RequestsApi  {

	@Autowired
	private RequestRepository repository;
	
	private HttpServletRequest request;
	
	public List<Request> listRequests(String customerName,String productName){
		if (!StringUtils.isEmpty(customerName)) {
			return repository.findByCustomerName(customerName);
		} else {
			if (!StringUtils.isEmpty(productName)) {
				return repository.findByProductName(productName);
			} else {
				return repository.findAll();
			}
		}
	}
	
	public ResponseEntity<Request> findRequestById(String id) {
		String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	
        	Request out = repository.getOne(id);
        	if (out == null) {
        		return new ResponseEntity<Request>(HttpStatus.NOT_FOUND);
        	} else {
        		return new ResponseEntity<Request>(out, HttpStatus.OK);
        	}
        }

        return new ResponseEntity<Request>(HttpStatus.NOT_FOUND);
	}
	
	public  ResponseEntity<Request> insertRequest(Request body) {
		
		String accept = request.getHeader("Accept");
    	 
    	 if (accept != null && accept.contains("application/json")) {
    		 
		
    		 return new ResponseEntity<Request>(repository.save(body), HttpStatus.OK);
    	 }
    	 
    	 return new ResponseEntity<Request>(HttpStatus.INTERNAL_SERVER_ERROR);
    	 
	}
	
	
	public ResponseEntity<List<Request>> getListRequests(String clientId , String
	 customerName,String productName){ 
		
		String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	return new ResponseEntity<List<Request>>(listRequests(customerName,
        			productName), HttpStatus.OK);
        }
        return new ResponseEntity<List<Request>>(HttpStatus.BAD_REQUEST);
	}
	
}
