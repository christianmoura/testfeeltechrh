/**
 * 
 */
package com.test.feel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.feel.api.CustomersController;
import com.test.feel.api.ProductsController;
import com.test.feel.business.CustomerService;
import com.test.feel.business.ProductService;
import com.test.feel.domain.Customer;
import com.test.feel.domain.Product;
import com.test.feel.factory.CreateProductFactoryTest;
import com.test.feel.repository.CustomerRepository;
import com.test.feel.repository.ProductRepository;

/**
 * @author Christian Bernardino de Moura
 *
 * christianbmoura@gmail.com
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ProductsController.class)
public class ProductControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProductService productControllerservice;

	@Mock
	private ProductRepository repository;
	
	@Mock
	private HttpServletRequest requestServlet;
	
	@Test
	public void productGetListTest() throws Exception {
		
		Product product = CreateProductFactoryTest.get("1", "Pendrive", new BigDecimal(15D));
		
		List<Product> products = new ArrayList<>();
		
		products.add(product);
		ResponseEntity<List<Product>> expect = new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		when(repository.findAll()).thenReturn(products);
		when(productControllerservice.listProducts()).thenReturn(expect);
		
		
		mockMvc.perform(get("/products").header("client_id" , "SOMETOKEN")).andExpect(status().isOk());
	}
	
	@Test
	public void productGetByIdTest() throws Exception {
		
		Product product = CreateProductFactoryTest.get("1", "Pendrive", new BigDecimal(15D));
		
		ResponseEntity<Product> expect = new ResponseEntity<Product>(product, HttpStatus.OK);
		when(repository.getOne("1")).thenReturn(product);
		when(productControllerservice.findProductById("1")).thenReturn(expect);
		
		
		mockMvc.perform(get("/products/1").header("client_id" , "SOMETOKEN"))
		.andExpect(status().isOk());
	}
	
	
	@Test
	public void productDeleteByIdTest() throws Exception {
		
		Product product = CreateProductFactoryTest.get("1", "Pendrive", new BigDecimal(15D));
		
		ResponseEntity<Product> expect = new ResponseEntity<Product>(product, HttpStatus.OK);
		when(repository.getOne("1")).thenReturn(product);
		when(productControllerservice.deleteProduct("1")).thenReturn(null);
		
		
		mockMvc.perform(delete("/products/1").header("client_id" , "SOMETOKEN"))
		.andExpect(status().isOk());
	}
	
	
}
