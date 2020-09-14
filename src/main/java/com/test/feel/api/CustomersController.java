/**
 * 
 */
package com.test.feel.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.feel.business.CustomerService;
import com.test.feel.domain.Body;
import com.test.feel.domain.Customer;
import com.test.feel.domain.Product;
import com.test.feel.domain.enums.Status;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Christian Bernardino de Moura
 *
 * christianbmoura@gmail.com
 */
@Api(tags = "Customers", description = "the customers API")
@RestController
public class CustomersController {
	private static final Logger log = LoggerFactory.getLogger(CustomersController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private CustomerService service;


    public CustomersController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }
	@ApiOperation(value = "List customers", nickname = "findCustomer", notes = "List customers according to the parameters", response = Customer.class, tags={ "Customers", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Customer.class),
        @ApiResponse(code = 206, message = "Partial Content", response = Customer.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class),
        @ApiResponse(code = 412, message = "Pagination Precondition Failed", response = String.class) })
    @RequestMapping(value = "/customers",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Customer>> findCustomer(@ApiParam(value = "Client ID" ,required=true) @RequestHeader(value="client_id", required=true) String clientId
    ,@Min(0L)@ApiParam(value = "It indicates from which index data should be returned. For example, inputing _offset=100 means that pagination should start from the 101st record", allowableValues = "", defaultValue = "0") @Valid @RequestParam(value = "_offset", required = false, defaultValue="0") Long _offset
    ,@Min(0L) @Max(100L) @ApiParam(value = "It indicates how many records are to be returned from the _offset. For example, inputing _limit=100 means that the pagination must return a maximum of 100 records", allowableValues = "", defaultValue = "100") @Valid @RequestParam(value = "_limit", required = false, defaultValue="100") Long _limit
    ,@ApiParam(value = "It indicates which attributes the results list should be ordered by. For example, inputing _sort=[name,age] means that the list must be ordered by the name and age attributes. If any attribute does not exist, it must be ignored") @Valid @RequestParam(value = "_sort", required = false) List<String> _sort
    ,@ApiParam(value = "It indicates which attributes are to be returned. For example, inputing _fields=[name,age] means that the list must contain only those attributes. If any attribute does not exist, it must be ignored") @Valid @RequestParam(value = "_fields", required = false) List<String> _fields
    ,@ApiParam(value = "Customer name") @Valid @RequestParam(value = "name", required = false) String name
    ,@ApiParam(value = "City of the customer's address") @Valid @RequestParam(value = "city", required = false) String city
    ,@ApiParam(value = "Product name that was requested by a customer") @Valid @RequestParam(value = "productName", required = false) String productName
    ,@ApiParam(value = "Customer status") @Valid @RequestParam(value = "status", required = false) Status status
    ){
		
           
                return service.listCustomers(name, city, productName, status);
               
       
	
	}
	
	@ApiOperation(value = "Find a customer", nickname = "findCustomerById", notes = "Return a customer according to the ID", response = Customer.class, tags={ "Customers", })
    @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "OK", response = Customer.class),
    @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
    @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
    @ApiResponse(code = 403, message = "Forbidden", response = String.class),
    @ApiResponse(code = 404, message = "Not Found", response = String.class) })
    @RequestMapping(value = "/customers/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Customer> findCustomerById(@ApiParam(value = "Client ID" ,required=true) @RequestHeader(value="client_id", required=true) String clientId
    , @ApiParam(value = "Unique identifier",required=true) @PathVariable("id") String id
    ){
		 
	                return service.findCustomerById(id);
	            
	        
	}
	
	@ApiOperation(value = "Insert a customer", nickname = "insertCustomer", notes = "Insert a customer", tags={ "Customers", })
    @ApiResponses(value = { 
    @ApiResponse(code = 201, message = "Created"),
    @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
    @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
    @ApiResponse(code = 403, message = "Forbidden", response = String.class),
    @ApiResponse(code = 422, message = "Unprocessable Entity", response = Error.class) })
    @RequestMapping(value = "/customers",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Customer> insertCustomer(@ApiParam(value = "Client ID" ,required=true) @RequestHeader(value="client_id", required=true) String clientId
    , @ApiParam(value = ""  )  @Valid @RequestBody Customer body
    ){
		
            return service.insertCustomer(body);
       
		
	}
	
	@ApiOperation(value = "Update a customer", nickname = "updateCustomer", notes = "Update a customer", response = Customer.class, tags={ "Customers", })
    @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "OK", response = Customer.class),
    @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
    @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
    @ApiResponse(code = 403, message = "Forbidden", response = String.class),
    @ApiResponse(code = 404, message = "Not Found", response = String.class),
    @ApiResponse(code = 422, message = "Unprocessable Entity", response = Error.class) })
    @RequestMapping(value = "/customers/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Customer> updateCustomer(@ApiParam(value = "Client ID" ,required=true) @RequestHeader(value="client_id", required=true) String clientId
    , @ApiParam(value = "Unique identifier",required=true) @PathVariable("id") String id
    , @ApiParam(value = ""  )  @Valid @RequestBody Customer body
    ){
		
                return service.updateCustomer(id, body);
        
	}
	
	 @ApiOperation(value = "Update status of a customer", nickname = "updateCustomerStatus", notes = "Update status of a customer", response = Customer.class, tags={ "Customers", })
	 @ApiResponses(value = { 
	 @ApiResponse(code = 200, message = "OK", response = Customer.class),
	 @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
	 @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
	 @ApiResponse(code = 403, message = "Forbidden", response = String.class),
	 @ApiResponse(code = 404, message = "Not Found", response = String.class) })
	 @RequestMapping(value = "/customers/{id}",
	        produces = { "application/json" }, 
	        consumes = { "application/json" },
	        method = RequestMethod.PATCH)
	 ResponseEntity<Customer> updateCustomerStatus(@ApiParam(value = "Client ID" ,required=true) @RequestHeader(value="client_id", required=true) String clientId
	 , @ApiParam(value = "Unique identifier",required=true) @PathVariable("id") String id
	 , @ApiParam(value = ""  )  @Valid @RequestBody Customer body
	 ){
		 
	                return service.patchCustomer(id, body);
	            
	        
	 }
}
