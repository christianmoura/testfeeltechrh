/**
 * 
 */
package com.test.feel;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.feel.api.CustomersController;
import com.test.feel.business.CustomerService;
import com.test.feel.business.RequestService;
import com.test.feel.domain.Address;
import com.test.feel.domain.Customer;
import com.test.feel.domain.Request;
import com.test.feel.domain.RequestCustomer;
import com.test.feel.domain.RequestProduct;
import com.test.feel.domain.enums.ProvinceEnum;
import com.test.feel.domain.enums.Status;
import com.test.feel.factory.CreateAddressFactoryTest;
import com.test.feel.factory.CreateCustomerFactoryTest;
import com.test.feel.factory.CreateRequestCustomerFactoryTest;
import com.test.feel.factory.CreateRequestFactoryTest;
import com.test.feel.factory.CreateRequestProductFatoryTest;
import com.test.feel.repository.CustomerRepository;
import com.test.feel.repository.RequestRepository;

/**
 * @author Christian Bernardino de Moura
 *
 * christianbmoura@gmail.com
 */

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CustomersController.class)
public class CustomerControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CustomerService customerControllerservice;

	@Mock
	private CustomerRepository repository;
	
	@Mock
	private HttpServletRequest requestServlet;
	
	@Test
	public void customerFindCustomerListTest() throws Exception {
		
		Address address = CreateAddressFactoryTest.get("1","Av. Bento Gonçalves, 1515", "Partenon", "Porto Alegre", "RJ");
		
		RequestProduct product = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		RequestCustomer customer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		Request request = CreateRequestFactoryTest.get("1", product, customer, 1, new BigDecimal(15D));
		
		List<Request> requests = new ArrayList<>();
		
		requests.add(request);
		
		Customer customerClient = CreateCustomerFactoryTest.get("1", "Christian", address, requests, Status.On);
		
		List<Customer> customers = new ArrayList<>();
		
		customers.add(customerClient);
		
		ResponseEntity<List<Customer>> expect = new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
		when(repository.findAll()).thenReturn(customers);
		when(customerControllerservice.listCustomers(null, null, null, null)).thenReturn(expect);
		
		mockMvc.perform(get("/customers").header("client_id" , "SOMETOKEN")).andExpect(status().isOk());
		
		
	}
	
	@Test
	public void customerGetCustomerByIdTest() throws Exception {
		
		Address address = CreateAddressFactoryTest.get("1","Av. Bento Gonçalves, 1515", "Partenon", "Porto Alegre", "RJ");
		
		RequestProduct product = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		RequestCustomer customer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		Request request = CreateRequestFactoryTest.get("1", product, customer, 1, new BigDecimal(15D));
		
		List<Request> requests = new ArrayList<>();
		
		requests.add(request);
		
		Customer customerClient = CreateCustomerFactoryTest.get("1", "Christian", address, requests, Status.On);
		
		
		ResponseEntity<Customer> expect = new ResponseEntity<Customer>(customerClient, HttpStatus.OK);
		when(repository.getOne("1")).thenReturn(customerClient);
		when(customerControllerservice.findCustomerById("1")).thenReturn(expect);
		
		mockMvc.perform(get("/customers/1").header("client_id" , "SOMETOKEN")).andExpect(status().isOk());
		
	}
	
	@Test
	public void customerGetCustomerByIdNotFoundTest() throws Exception {
		
		Address address = CreateAddressFactoryTest.get("1","Av. Bento Gonçalves, 1515", "Partenon", "Porto Alegre", "RJ");
		
		RequestProduct product = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		RequestCustomer customer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		Request request = CreateRequestFactoryTest.get("1", product, customer, 1, new BigDecimal(15D));
		
		List<Request> requests = new ArrayList<>();
		
		requests.add(request);
		
		Customer customerClient = CreateCustomerFactoryTest.get("1", "Christian", address, requests, Status.On);
		
		
		ResponseEntity<Customer> expect = new ResponseEntity<Customer>(customerClient, HttpStatus.OK);
		when(requestServlet.getHeader("Accept")).thenReturn("application/json");
		when(repository.getOne("1")).thenReturn(customerClient);
		when(customerControllerservice.findCustomerById("1")).thenReturn(expect);
		
		mockMvc.perform(get("/customers/2").header("client_id" , "SOMETOKEN")).andExpect(status().isOk());
		
	}
	
	
	
}
