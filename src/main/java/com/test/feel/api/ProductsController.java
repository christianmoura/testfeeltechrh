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
import com.test.feel.api.exception.NotFoundException;
import com.test.feel.business.ProductService;
import com.test.feel.domain.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Christian Bernardino de Moura
 *
 * christiabmoura@gmail.com
 */
@Api(tags = "Products", description = "the products API")
@RestController
public class ProductsController {
	
	private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
	
    private static final Logger log = LoggerFactory.getLogger(ProductsController.class);
    
	/**
	 * @param objectMapper
	 * @param request
	 */
	public ProductsController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@Autowired
	private ProductService service;
	
	@ApiOperation(value = "List products", nickname = "findProduct", notes = "List products according to the parameters", response = Product.class, tags={ "Products", })
    @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "OK", response = Product.class),
    @ApiResponse(code = 400, message = "Bad Request", response = Error.class) })
    @RequestMapping(value = "/products",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Product>> findProduct( @ApiParam(value = "Client ID" 
    ,required=true) @RequestHeader(value="client_id", required=true) 
    String clientId,@ApiParam(value = "Product name") @Valid 
    @RequestParam(value = "name", required = false) String name
    		){
		
            return service.listProducts();
            
       
	}
	
	@ApiOperation(value = "Find a product", nickname = "findProductById", notes = "Return a product according to the ID", response = Product.class, tags={ "Products", })
    @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "OK", response = Product.class),
    @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
    @ApiResponse(code = 404, message = "Not Found", response = String.class) })
    @RequestMapping(value = "/products/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Product> findProductById(@ApiParam(value = "Client ID" ,required=true) @RequestHeader(value="client_id", required=true) String clientId
    , @ApiParam(value = "Unique identifier",required=true) @PathVariable("id") String id
    ){
		    return service.findProductById(id);
       
	}
	
    @ApiOperation(value = "Insert a product", nickname = "insertProduct", notes = "Insert a product", tags={ "Products", })
    @ApiResponses(value = { 
    @ApiResponse(code = 201, message = "Created"),
    @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
    @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
    @ApiResponse(code = 403, message = "Forbidden", response = String.class),
    @ApiResponse(code = 422, message = "Unprocessable Entity", response = Error.class) })
    @RequestMapping(value = "/products",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
   public ResponseEntity<Void> insertProduct(@ApiParam(value = "Client ID" 
    	, required=true) @RequestHeader(value="client_id", required=true) String clientId
    	, @ApiParam(value = ""  )  @Valid @RequestBody Product body
    ){
    	 
                  return service.insertProduct(body);
             
        
    }
    
    @ApiOperation(value = "Remove a product", nickname = "removeProduct", notes = "Remove a product", tags={ "Products", })
    @ApiResponses(value = { 
    @ApiResponse(code = 204, message = "No Content"),
    @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
    @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
    @ApiResponse(code = 403, message = "Forbidden", response = String.class),
    @ApiResponse(code = 404, message = "Not Found", response = String.class) })
    @RequestMapping(value = "/products/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> removeProduct(@ApiParam(value = "Client ID" 
    , required=true) @RequestHeader(value="client_id", required=true) String clientId
    , @ApiParam(value = "Unique identifier",required=true) @PathVariable("id") String id
    ) throws NotFoundException {
    	
    	return service.deleteProduct(id);
    }
	
}
