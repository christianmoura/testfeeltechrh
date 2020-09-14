package com.test.feel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.test.feel.api.RequestsController;
import com.test.feel.api.exception.NotFoundException;
import com.test.feel.business.CustomerService;
import com.test.feel.business.ProductService;
import com.test.feel.business.RequestService;
import com.test.feel.domain.Address;
import com.test.feel.domain.Body;
import com.test.feel.domain.Customer;
import com.test.feel.domain.Product;
import com.test.feel.domain.Request;
import com.test.feel.domain.RequestCustomer;
import com.test.feel.domain.RequestProduct;
import com.test.feel.domain.enums.ProvinceEnum;
import com.test.feel.domain.enums.Status;
import com.test.feel.factory.CreateAddressFactoryTest;
import com.test.feel.factory.CreateCustomerFactoryTest;
import com.test.feel.factory.CreateProductFactoryTest;
import com.test.feel.factory.CreateRequestCustomerFactoryTest;
import com.test.feel.factory.CreateRequestFactoryTest;
import com.test.feel.factory.CreateRequestProductFatoryTest;
import com.test.feel.repository.CustomerRepository;
import com.test.feel.repository.ProductRepository;
import com.test.feel.repository.RequestRepository;



@SpringBootTest
class FeelApplicationTests {

	
	
	@Test
	void contextLoads() {
	}

	@InjectMocks
	private RequestService requestService;
	
	@InjectMocks
	private ProductService productService;
	
	@InjectMocks
	private CustomerService customerService;
	
	@InjectMocks
	private RequestsController requestsController;
	
	@Mock
	private HttpServletRequest requestServlet;
	
	@Mock
	private RequestRepository requestRepository;
	
	@Mock
	private ProductRepository productRepository;
	
	@Mock
	private CustomerRepository customerRepository;
	
	
	
	
	
	@Test
	public void getAllRequest() {
		
		RequestCustomer requestCustomer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		RequestProduct requestProduct = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		Request request = CreateRequestFactoryTest.get("1", requestProduct, requestCustomer, 1, new BigDecimal(15D));
		
		List<Request> listRequest = new ArrayList<>();
		listRequest.add(request);
		
		when(requestRepository.findAll()).thenReturn(listRequest);
		
		assertEquals(requestService.listRequests(null, null).size(), 1);
	}
	
	@Test
	public void getAllRequestByCustomerNameTest() {
		
		RequestCustomer requestCustomer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		RequestProduct requestProduct = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		Request request = CreateRequestFactoryTest.get("1", requestProduct, requestCustomer, 1, new BigDecimal(15D));
		
		List<Request> listRequest = new ArrayList<>();
		listRequest.add(request);
		
		when(requestRepository.findByCustomerName("Christian")).thenReturn(listRequest);
		
		assertEquals(requestService.listRequests("Christian", null), listRequest);
	}
	
	@Test
	public void getAllRequestByProductNameTest() {
		
		RequestCustomer requestCustomer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		RequestProduct requestProduct = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		Request request = CreateRequestFactoryTest.get("1", requestProduct, requestCustomer, 1, new BigDecimal(15D));
		
		List<Request> listRequest = new ArrayList<>();
		listRequest.add(request);
		
		when(requestRepository.findByProductName("Pendrive")).thenReturn(listRequest);
		
		assertEquals(requestService.listRequests(null, "Pendrive"), listRequest);
	}
	
	@Test
	public void getAllRequestEmptyTest() {
		
		List<Request> listRequest = new ArrayList<>();
		
		when(requestRepository.findAll()).thenReturn(listRequest);
		
		assertEquals(requestService.listRequests(null, null).size(), 0);
	}
	
	@Test
	public void getRequestByIdTest() {
		
		RequestCustomer requestCustomer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		RequestProduct requestProduct = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		Request request = CreateRequestFactoryTest.get("1", requestProduct, requestCustomer, 1, new BigDecimal(15D));
		ResponseEntity<Request> expect = new ResponseEntity<Request>(request, HttpStatus.OK);
		when(requestServlet.getHeader("Accept")).thenReturn("application/json");
		when(requestRepository.getOne("1")).thenReturn(request);
		
		assertEquals(expect, requestService.findRequestById("1"));
	}
	
	@Test
	public void getRequestByIdNullTest() {
		
		
		when(requestRepository.getOne(null)).thenReturn(null);
		
		assertEquals(HttpStatus.NOT_FOUND, requestService.findRequestById(null).getStatusCode());
	}
	
	@Test
	public void getRequestByIdInvalidTest() {
		
		RequestCustomer requestCustomer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		RequestProduct requestProduct = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		Request request = CreateRequestFactoryTest.get("1", requestProduct, requestCustomer, 1, new BigDecimal(15D));
		ResponseEntity<Request> expect = new ResponseEntity<Request>(HttpStatus.NOT_FOUND);
		when(requestRepository.getOne("1")).thenReturn(request);
		
		assertEquals(expect ,requestService.findRequestById("2"));
	}
	
	@Test
	public void postRequestTest() {
		
		RequestCustomer requestCustomer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		RequestProduct requestProduct = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		Request request = CreateRequestFactoryTest.get("1", requestProduct, requestCustomer, 1, new BigDecimal(15D));
		
		when(requestRepository.save(request)).thenReturn(request);
		
		assertNotNull(requestService.insertRequest(request));
	}
	
	@Test
	public void getAllCustomerTest() {
		
		Address address = CreateAddressFactoryTest.get("1", "Av. Bento Gonçalvez 1515", "Partenon", "Angra dos Reis", "RJ" );
		
		RequestCustomer requestCustomer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		RequestProduct requestProduct = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		Request request = CreateRequestFactoryTest.get("1", requestProduct, requestCustomer, 1, new BigDecimal(15D));
		
		List<Request> listRequest = new ArrayList<>();
		listRequest.add(request);
		
		Customer customer = CreateCustomerFactoryTest.get("1", "Christian", address, listRequest, Status.On);
		
		List<Customer> listCustomer = new ArrayList<>();
		
		listCustomer.add(customer);
		
		when(requestServlet.getHeader("Accept")).thenReturn("application/json");
		when(customerRepository.findAll()).thenReturn(listCustomer);
		
		assertEquals(customerService.listCustomers(null, null, null, null).getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void getAllCustomerByNameTest() {
		
		Address address = CreateAddressFactoryTest.get("1", "Av. Bento Gonçalvez 1515", "Partenon", "Angra dos Reis", "RJ" );
		
		RequestCustomer requestCustomer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		RequestProduct requestProduct = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		Request request = CreateRequestFactoryTest.get("1", requestProduct, requestCustomer, 1, new BigDecimal(15D));
		
		List<Request> listRequest = new ArrayList<>();
		listRequest.add(request);
		
		Customer customer = CreateCustomerFactoryTest.get("1", "Christian", address, listRequest, Status.On);
		
		List<Customer> listCustomer = new ArrayList<>();
		
		listCustomer.add(customer);
		when(requestServlet.getHeader("Accept")).thenReturn("application/json");
		when(customerRepository.findByName("Christian")).thenReturn(listCustomer);
		
		assertEquals(customerService.listCustomers("Christian", null, null, null).getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void getAllCustomerByCityTest() {
		
		Address address = CreateAddressFactoryTest.get("1", "Av. Bento Gonçalvez 1515", "Partenon", "Angra dos Reis", "RJ" );
		
		RequestCustomer requestCustomer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		RequestProduct requestProduct = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		Request request = CreateRequestFactoryTest.get("1", requestProduct, requestCustomer, 1, new BigDecimal(15D));
		
		List<Request> listRequest = new ArrayList<>();
		listRequest.add(request);
		
		Customer customer = CreateCustomerFactoryTest.get("1", "Christian", address, listRequest, Status.On);
		
		List<Customer> listCustomer = new ArrayList<>();
		
		listCustomer.add(customer);
		ResponseEntity<List<Customer>> out = new ResponseEntity<List<Customer>>(listCustomer,HttpStatus.OK);
		when(requestServlet.getHeader("Accept")).thenReturn("application/json");
		when(customerRepository.findByAddressCity("Angra dos Reis")).thenReturn(listCustomer);
		
		assertEquals(out, customerService.listCustomers(null, "Angra dos Reis", null, null));
	}
	
	@Test
	public void getAllCustomerByProductTest() {
		
		Address address = CreateAddressFactoryTest.get("1", "Av. Bento Gonçalvez 1515", "Partenon", "Angra dos Reis", "RJ" );
		
		RequestCustomer requestCustomer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		RequestProduct requestProduct = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		Request request = CreateRequestFactoryTest.get("1", requestProduct, requestCustomer, 1, new BigDecimal(15D));
		
		List<Request> listRequest = new ArrayList<>();
		listRequest.add(request);
		
		Customer customer = CreateCustomerFactoryTest.get("1", "Christian", address, listRequest, Status.On);
		
		List<Customer> listCustomer = new ArrayList<>();
		
		listCustomer.add(customer);
		ResponseEntity<List<Customer>> out = new ResponseEntity<List<Customer>>(listCustomer,HttpStatus.OK);
		when(requestServlet.getHeader("Accept")).thenReturn("application/json");
		when(customerRepository.findByProductName("Pendrive")).thenReturn(listCustomer);
		
		assertEquals(customerService.listCustomers(null, null, "Pendrive", null).getStatusCode(), out.getStatusCode());
	}
	
	@Test
	public void getAllCustomerByStatusTest() {
		
		Address address = CreateAddressFactoryTest.get("1", "Av. Bento Gonçalvez 1515", "Partenon", "Angra dos Reis", "RJ" );
		
		RequestCustomer requestCustomer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		RequestProduct requestProduct = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		Request request = CreateRequestFactoryTest.get("1", requestProduct, requestCustomer, 1, new BigDecimal(15D));
		
		List<Request> listRequest = new ArrayList<>();
		listRequest.add(request);
		
		Customer customer = CreateCustomerFactoryTest.get("1", "Christian", address, listRequest, Status.On);
		
		List<Customer> listCustomer = new ArrayList<>();
		
		listCustomer.add(customer);
		ResponseEntity<List<Customer>> out = new ResponseEntity<List<Customer>>(listCustomer,HttpStatus.OK);
		when(requestServlet.getHeader("Accept")).thenReturn("application/json");
		when(customerRepository.findByStatus(Status.On)).thenReturn(listCustomer);
		
		assertEquals(customerService.listCustomers(null, null, null, Status.On), out);
	}
	
	@Test
	public void getAllCustomerEmptyTest() {
		
		Address address = CreateAddressFactoryTest.get("1", "Av. Bento Gonçalvez 1515", "Partenon", "Angra dos Reis", "RJ" );
		
		RequestCustomer requestCustomer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		RequestProduct requestProduct = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		Request request = CreateRequestFactoryTest.get("1", requestProduct, requestCustomer, 1, new BigDecimal(15D));
		
		List<Request> listRequest = new ArrayList<>();
		listRequest.add(request);
		
		Customer customer = CreateCustomerFactoryTest.get("1", "Christian", address, listRequest, Status.On);
		
		List<Customer> listCustomer = new ArrayList<>();
		ResponseEntity<List<Customer>> out = new ResponseEntity<List<Customer>>(listCustomer,HttpStatus.OK);
		when(requestServlet.getHeader("Accept")).thenReturn("application/json");
		when(customerRepository.findAll()).thenReturn(listCustomer);
		
		assertEquals(customerService.listCustomers(null, null, null, null), out);
	}
	
	@Test
	public void getAllCustomerNameInvalidTest() {
		
		Address address = CreateAddressFactoryTest.get("1", "Av. Bento Gonçalvez 1515", "Partenon", "Angra dos Reis", "RJ" );
		
		RequestCustomer requestCustomer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		RequestProduct requestProduct = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		Request request = CreateRequestFactoryTest.get("1", requestProduct, requestCustomer, 1, new BigDecimal(15D));
		
		List<Request> listRequest = new ArrayList<>();
		listRequest.add(request);
		
		Customer customer = CreateCustomerFactoryTest.get("1", "Christian", address, listRequest, Status.On);
		
		List<Customer> listCustomer = new ArrayList<>();
		ResponseEntity<List<Customer>> out = new ResponseEntity<List<Customer>>(listCustomer,HttpStatus.OK);
		when(requestServlet.getHeader("Accept")).thenReturn("application/json");
		when(customerRepository.findByName("Christian")).thenReturn(listCustomer);
		
		assertEquals(customerService.listCustomers("William", null, null, null), out);
	}
	
	@Test
	public void getAllCustomerCityInvalidTest() {
		
		Address address = CreateAddressFactoryTest.get("1", "Av. Bento Gonçalvez 1515", "Partenon", "Angra dos Reis", "RJ" );
		
		RequestCustomer requestCustomer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		RequestProduct requestProduct = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		Request request = CreateRequestFactoryTest.get("1", requestProduct, requestCustomer, 1, new BigDecimal(15D));
		
		List<Request> listRequest = new ArrayList<>();
		listRequest.add(request);
		
		Customer customer = CreateCustomerFactoryTest.get("1", "Christian", address, listRequest, Status.On);
		
		List<Customer> listCustomer = new ArrayList<>();
		ResponseEntity<List<Customer>> out = new ResponseEntity<List<Customer>>(listCustomer,HttpStatus.OK);
		when(requestServlet.getHeader("Accept")).thenReturn("application/json");
		when(customerRepository.findByAddressCity("Angra dos Reis")).thenReturn(listCustomer);
		
		assertEquals(customerService.listCustomers(null, "Porto Alegre", null, null), out);
	}
	
	@Test
	public void getAllCustomerProductNameInvalidTest() {
		
		Address address = CreateAddressFactoryTest.get("1", "Av. Bento Gonçalvez 1515", "Partenon", "Angra dos Reis", "RJ" );
		
		RequestCustomer requestCustomer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		RequestProduct requestProduct = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		Request request = CreateRequestFactoryTest.get("1", requestProduct, requestCustomer, 1, new BigDecimal(15D));
		
		List<Request> listRequest = new ArrayList<>();
		listRequest.add(request);
		
		Customer customer = CreateCustomerFactoryTest.get("1", "Christian", address, listRequest, Status.On);
		
		List<Customer> listCustomer = new ArrayList<>();
		
		ResponseEntity<List<Customer>> out = new ResponseEntity<List<Customer>>(listCustomer,HttpStatus.OK);
		when(requestServlet.getHeader("Accept")).thenReturn("application/json");
		when(customerRepository.findByProductName("Pendrive")).thenReturn(listCustomer);
		
		assertEquals(customerService.listCustomers(null, null, "Notebook", null), out);
	}
	
	@Test
	public void getAllCustomerStatusInvalidTest() {
		
		Address address = CreateAddressFactoryTest.get("1", "Av. Bento Gonçalvez 1515", "Partenon", "Angra dos Reis", "RJ" );
		
		RequestCustomer requestCustomer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		RequestProduct requestProduct = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		Request request = CreateRequestFactoryTest.get("1", requestProduct, requestCustomer, 1, new BigDecimal(15D));
		
		List<Request> listRequest = new ArrayList<>();
		listRequest.add(request);
		
		Customer customer = CreateCustomerFactoryTest.get("1", "Christian", address, listRequest, Status.On);
		
		List<Customer> listCustomer = new ArrayList<>();

		ResponseEntity<List<Customer>> out = new ResponseEntity<List<Customer>>(listCustomer,HttpStatus.OK);
		when(requestServlet.getHeader("Accept")).thenReturn("application/json");
		when(customerRepository.findByStatus(Status.On)).thenReturn(listCustomer);
		
		assertEquals(customerService.listCustomers(null, null, null, null), out);
	}
	
	@Test
	public void getCustomerByIdTest() {
		
		Address address = CreateAddressFactoryTest.get("1", "Av. Bento Gonçalvez 1515", "Partenon", "Angra dos Reis", "RJ" );
		
		RequestCustomer requestCustomer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		RequestProduct requestProduct = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		Request request = CreateRequestFactoryTest.get("1", requestProduct, requestCustomer, 1, new BigDecimal(15D));
		
		List<Request> listRequest = new ArrayList<>();
		listRequest.add(request);
		
		when(requestServlet.getHeader("Accept")).thenReturn("application/json");
		Customer customer = CreateCustomerFactoryTest.get("1", "Christian", address, listRequest, Status.On);
		ResponseEntity<Customer> out = new ResponseEntity<Customer>(customer,HttpStatus.OK);
		when(customerRepository.getOne("1")).thenReturn(customer);
		
		assertEquals(out.getStatusCode(),customerService.findCustomerById("1").getStatusCode());
	}
	
	@Test
	public void getCustomerByIdEmptyTest() {
		ResponseEntity<Customer> out = new ResponseEntity<Customer>(HttpStatus.OK);
		when(requestServlet.getHeader("Accept")).thenReturn("application/json");
		when(customerRepository.getOne(null)).thenReturn(null);
		
		assertEquals(out, customerService.findCustomerById(null));
	}
	
	@Test
	public void getCustomerByIdInvalidTest() {
		Address address = CreateAddressFactoryTest.get("1", "Av. Bento Gonçalvez 1515", "Partenon", "Angra dos Reis", "RJ" );
		
		RequestCustomer requestCustomer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		RequestProduct requestProduct = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		Request request = CreateRequestFactoryTest.get("1", requestProduct, requestCustomer, 1, new BigDecimal(15D));
		
		List<Request> listRequest = new ArrayList<>();
		listRequest.add(request);
		
		Customer customer = CreateCustomerFactoryTest.get("1", "Christian", address, listRequest, Status.On);
		
		
		when(customerRepository.getOne("1")).thenReturn(customer);
		
		assertEquals(customerService.findCustomerById("2").getStatusCode(), HttpStatus.NOT_FOUND);
	}
	
	@Test
	public void postCustomerTest() {
		Address address = CreateAddressFactoryTest.get("1", "Av. Bento Gonçalvez 1515", "Partenon", "Angra dos Reis", "RJ" );
		
		RequestCustomer requestCustomer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		RequestProduct requestProduct = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		Request request = CreateRequestFactoryTest.get("1", requestProduct, requestCustomer, 1, new BigDecimal(15D));
		
		List<Request> listRequest = new ArrayList<>();
		listRequest.add(request);
		
		Customer customer = CreateCustomerFactoryTest.get("1", "Christian", address, listRequest, Status.On);
		
		
		when(customerRepository.save(customer)).thenReturn(customer);
		
		assertNotNull(customerService.insertCustomer(customer));
	}
	
	@Test
	public void putCustomerTest() {
		Address address = CreateAddressFactoryTest.get("1", "Av. Bento Gonçalvez 1515", "Partenon", "Angra dos Reis", "RJ" );
		
		RequestCustomer requestCustomer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		RequestProduct requestProduct = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		Request request = CreateRequestFactoryTest.get("1", requestProduct, requestCustomer, 1, new BigDecimal(15D));
		
		List<Request> listRequest = new ArrayList<>();
		listRequest.add(request);
		
		Customer customer = CreateCustomerFactoryTest.get("1", "Christian", address, listRequest, Status.On);
		
		
		when(customerRepository.save(customer)).thenReturn(customer);
		
		assertNotNull(customerService.updateCustomer("1", customer));
	}
	
	@Test
	public void patchtCustomerTest() {
		Address address = CreateAddressFactoryTest.get("1", "Av. Bento Gonçalvez 1515", "Partenon", "Angra dos Reis", "RJ" );
		
		RequestCustomer requestCustomer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		RequestProduct requestProduct = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		Request request = CreateRequestFactoryTest.get("1", requestProduct, requestCustomer, 1, new BigDecimal(15D));
		
		List<Request> listRequest = new ArrayList<>();
		listRequest.add(request);
		
		Customer customer = CreateCustomerFactoryTest.get("1", "Christian", address, listRequest, Status.On);
		
		
		when(customerRepository.save(customer)).thenReturn(customer);
		
		assertNotNull(customerService.patchCustomer("1", customer));
	}
	
	@Test
	public void getAllProductTest() {
		
		Product product = CreateProductFactoryTest.get("1", "Pendrive", new BigDecimal(15D));
		
		List<Product> listProduct = new ArrayList<>();
		listProduct.add(product);
		ResponseEntity<List<Product>> out = new ResponseEntity<List<Product>>(listProduct,HttpStatus.OK);
		when(requestServlet.getHeader("Accept")).thenReturn("application/json");
		when(productRepository.findAll()).thenReturn(listProduct);
		assertEquals(productService.listProducts(), out);
	}
	
	@Test
	public void getAllProductNullTest() {
		
		when(requestServlet.getHeader("Accept")).thenReturn("application/json");
		when(productRepository.findAll()).thenReturn(null);
		ResponseEntity<List<Product>> out = new ResponseEntity<List<Product>>(HttpStatus.OK);
		assertEquals(out, productService.listProducts());
	}
	
	@Test
	public void getProductByIdTest() {
		
		Product product = CreateProductFactoryTest.get("1", "Pendrive", new BigDecimal(15D));
		
		when(productRepository.getOne("1")).thenReturn(product);
		assertNotNull(productService.findProductById("1"));
	}
	
	@Test
	public void getProductByIdInvalidTest() {
		
		Product product = CreateProductFactoryTest.get("1", "Pendrive", new BigDecimal(15D));
		when(requestServlet.getHeader("Accept")).thenReturn("application/json");
		when(productRepository.getOne("1")).thenReturn(product);
		ResponseEntity<Product> out = new ResponseEntity<Product>(HttpStatus.OK);
		assertEquals(out,productService.findProductById("2"));
	}
	
	@Test
	public void postProductTest() {
		Product product = CreateProductFactoryTest.get("1", "Pendrive", new BigDecimal(15D));
		when(requestServlet.getHeader("Accept")).thenReturn("application/json");
		when(productRepository.save(product)).thenReturn(product);
		
		ResponseEntity<Void> out = new ResponseEntity<Void>(HttpStatus.OK);
		
		assertEquals(productService.insertProduct(product), out);
	}
	
	@Test
	public void deleteProductTest() throws NotFoundException {
		Product product = CreateProductFactoryTest.get("1", "Pendrive", new BigDecimal(15D));
		
		when(productRepository.getOne("1")).thenReturn(product);
		
		productService.deleteProduct("1");
		
		verify(productRepository, times(1)).delete(product);
	}
	
	@Test
	public void deleteProductInvalidTest() throws NotFoundException {
		Product product = CreateProductFactoryTest.get("1", "Pendrive", new BigDecimal(15D));
		
		when(productRepository.getOne("1")).thenReturn(product);
		
		Assertions.assertThrows(NotFoundException.class, () ->{
			
			productService.deleteProduct("2");
			
		});
			
	}
	
	@Test
	public void bodyGetStatusTest() {
		
		String out = "On";
		Body body = new Body();
		body.setStatus(Status.On);
		assertEquals(body.getStatus().toString(), out);
		
	}
	
	@Test
	public void bodyHashTest() {
		
		Body body = new Body();
		
		assertTrue(body.hashCode()>0);
		
	}
	
	@Test
	public void bodyStatusTest() {
		
		String out = "On";
		Body body = new Body();
		body.status(Status.On);

		assertEquals(body.status(Status.On).getStatus().toString(), Status.On.toString());
		
	}
	@Test
	public void bodyEqualStatusTest() {
		
		Body body = new Body();
		body.setStatus(Status.On);
		Body bodyOut = new Body();
		bodyOut.setStatus(Status.On);
		
		assertTrue(body.equals(bodyOut));
		
	}
	
	@Test
	public void bodyToStringTest() {
		
		Body body = new Body();
		body.setStatus(Status.On);
		
		assertNotNull(body.toString());
		
	}
	
	@Test
	public void requestProductGetTest() {
		
		String id = "1";
		String name = "Pendrive";
		
		RequestProduct requestProduct = new RequestProduct();
		
		requestProduct.setId(id);
		requestProduct.setName(name);
	
		assertEquals(requestProduct.getId().toString(), "1");
		
	}
	
	@Test
	public void requestProductToStringTest() {
		
		String id = "1";
		String name = "Pendrive";
		
		RequestProduct requestProductOut = CreateRequestProductFatoryTest.get(id, name);
	
		assertNotNull(requestProductOut.toString());
		
	}
	
	@Test
	public void requestProductEqualTest() {
		
		String id = "1";
		String name = "Pendrive";
		
		RequestProduct requestProduct = new RequestProduct();
		
		requestProduct.setId(id);
		requestProduct.setName(name);
		
		RequestProduct requestProductOut = new RequestProduct();  
				
		requestProductOut =	requestProduct;
	
		assertTrue(requestProduct.equals(requestProductOut));
		
	}
	
	
	
}
