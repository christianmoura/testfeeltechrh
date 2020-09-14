/**
 * 
 */
package com.test.feel.business;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.test.feel.api.adapter.CustomersApi;
import com.test.feel.domain.Customer;
import com.test.feel.domain.enums.ProvinceEnum;
import com.test.feel.domain.enums.Status;
import com.test.feel.repository.CustomerRepository;


/**
 * @author Christian Bernardino de Moura
 *
 * christianbmoura@gmail.com
 */

@Service
public class CustomerService implements CustomersApi  {

	@Autowired
	private CustomerRepository repository;
	
	private HttpServletRequest request;
	
	public ResponseEntity<List<Customer>> listCustomers(String name, String city, String productName, Status status){
		List<Customer> out = new ArrayList<>();
		
		if (!StringUtils.isEmpty(name)) {
			out = repository.findByName(name);
		} else {
			if(!StringUtils.isEmpty(city)) {
				out = repository.findByAddressCity(city);
			} else {
				if (!StringUtils.isEmpty(productName)) {
					out = repository.findByProductName(productName);
				} else {
					if (status == null) {
						out = repository.findAll();
					}else {
						if (!StringUtils.isEmpty(status.getStatus())) {
							out = repository.findByStatus(status);
						} else {
							out = repository.findAll();
						}
					}
				}
			}
		}
		
		String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	return new ResponseEntity<List<Customer>>(out,HttpStatus.OK);
        
        }
        return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
	}
	
	private String validProvince(String in) {
		String out = "";
		
		if (in.equalsIgnoreCase(ProvinceEnum.MG.getProvince()))
			out = ProvinceEnum.MG.getProvince();
		else if (in.equalsIgnoreCase(ProvinceEnum.RJ.getProvince()))
			out = ProvinceEnum.RJ.getProvince();
		else if (in.equalsIgnoreCase(ProvinceEnum.SP.getProvince()))
			out = ProvinceEnum.SP.getProvince();
		else
			out = null;
		return out;
	}
	
	public ResponseEntity<Customer> findCustomerById(String id) {
		String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            
		
        	return new ResponseEntity<Customer>(repository.getOne(id), HttpStatus.OK);
		
        }

        return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<Customer> insertCustomer(Customer customer) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
            
			if (customer.getAddress() != null) {
				if (customer.getAddress().getProvince() != null) {
					String provinceIn = customer.getAddress().getProvince();
					
					String provinceOut = validProvince(provinceIn);
					
					customer.getAddress().setProvince(provinceOut);
				}
			}
			
			return new ResponseEntity<Customer>(repository.save(customer),HttpStatus.OK);
		}

		return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public ResponseEntity<Customer> updateCustomer(String id, Customer customer) {
		String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            
			customer.setId(id);
			return new ResponseEntity<Customer>(repository.save(customer), HttpStatus.OK);
		
	    
        }

        return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public ResponseEntity<Customer> patchCustomer(String id, Customer customer) {
		String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	        		
           	customer.setId(id);
           	return new ResponseEntity<Customer>(repository.save(customer), HttpStatus.NOT_IMPLEMENTED);
        }

        return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
}
