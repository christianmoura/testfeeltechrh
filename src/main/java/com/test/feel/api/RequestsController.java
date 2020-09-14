/**
 * 
 */
package com.test.feel.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.feel.business.RequestService;

import com.test.feel.domain.Request;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

/**
 * @author Christian Bernardino de Moura
 *
 * christianbmoura@gmail.com
 */
@Api(tags = "Requests", description = "the customers API")
@RestController
public class RequestsController  {

	private static final Logger log = LoggerFactory.getLogger(RequestsController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private RequestService service;


    public RequestsController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @ApiOperation(value = "List requests", nickname = "findRequest", notes = "List requests according to the parameters. It is mandatory to inform customer name or product name", response = Request.class, tags={ "Requests", })
    @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "OK", response = Request.class),
    @ApiResponse(code = 400, message = "Bad Request", response = Error.class) })
    @RequestMapping(value = "/requests",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
   public ResponseEntity<List<Request>> findRequest(@ApiParam(value = "Client ID" ,required=true) @RequestHeader(value="client_id", required=true) String clientId
    , @ApiParam(value = "Customer name") @Valid @RequestParam(value = "customerName", required = false) String customerName
    , @ApiParam(value = "Product name") @Valid @RequestParam(value = "productName", required = false) String productName
    ) {
		
    			return service.getListRequests(clientId, customerName, productName);
    	
              
            
      
    }
    
    @ApiOperation(value = "Find a request", nickname = "findRequestById", notes = "Return a request according to the ID", response = Request.class, tags={ "Requests", })
    @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "OK", response = Request.class),
    @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
    @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
    @ApiResponse(code = 403, message = "Forbidden", response = String.class),
    @ApiResponse(code = 404, message = "Not Found", response = String.class) })
    @RequestMapping(value = "/requests/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Request> findRequestById(@ApiParam(value = "Client ID" ,required=true) @RequestHeader(value="client_id", required=true) String clientId
    , @ApiParam(value = "Unique identifier",required=true) @PathVariable("id") String id
    ){
    	
            
                return service.findRequestById(id);
            
      
    }
	
    @ApiOperation(value = "Insert a request", nickname = "insertRequest", notes = "Insert a request", tags={ "Requests", })
    @ApiResponses(value = { 
    @ApiResponse(code = 201, message = "Created"),
    @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
    @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
    @ApiResponse(code = 403, message = "Forbidden", response = String.class),
    @ApiResponse(code = 422, message = "Unprocessable Entity", response = Error.class) })
    @RequestMapping(value = "/requests",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Request> insertRequest(@ApiParam(value = "Client ID" ,required=true) @RequestHeader(value="client_id", required=true) String clientId
    , @ApiParam(value = ""  )  @Valid @RequestBody Request body
    ){
    	          
             return service.insertRequest(body);
        
 		
    }
    
}
