/**
 * 
 */
package com.test.feel.api.adapter;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.test.feel.domain.Request;


/**
 * @author Christian Bernardino de Moura
 *
 * christianbmoura@gmail.com
 */
public interface RequestsApi {

	public List<Request> listRequests(String customerName,String productName);
	
	public ResponseEntity<Request>findRequestById(String id);
	
	public ResponseEntity<Request> insertRequest(Request request);
	
	/*
	 * public ResponseEntity<List<Request>> getListRequests(String clientId , String
	 * customerName,String productName);
	 */
	
}
