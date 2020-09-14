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
import com.test.feel.api.RequestsController;
import com.test.feel.business.RequestService;
import com.test.feel.domain.Request;
import com.test.feel.domain.RequestCustomer;
import com.test.feel.domain.RequestProduct;
import com.test.feel.factory.CreateRequestCustomerFactoryTest;
import com.test.feel.factory.CreateRequestFactoryTest;
import com.test.feel.factory.CreateRequestProductFatoryTest;
import com.test.feel.repository.RequestRepository;

/**
 * @author Christian Bernardino de Moura
 *
 * christianbmoura@gmail.com
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = RequestsController.class)
public class RequestControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RequestService requestControllerservice;

	@Mock
	private RequestRepository repository;
	
	@Test
	public void requestGetListRequestTest() throws Exception {
		
		RequestCustomer requestCustomer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		RequestProduct requestProduct = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		Request request = CreateRequestFactoryTest.get("1", requestProduct, requestCustomer, 1, new BigDecimal(15D));
		
		List<Request> listRequest = new ArrayList<>();
		listRequest.add(request);
		
		ResponseEntity<List<Request>> expect = new ResponseEntity<List<Request>>(listRequest, HttpStatus.OK);
		when(repository.findAll()).thenReturn(listRequest);
		when(requestControllerservice.getListRequests("teste", null, null)).thenReturn(expect);
		
		mockMvc.perform(get("/requests").header("client_id" , "SOMETOKEN")).andExpect(status().isOk());
		
	}
	
	@Test
	public void requestGetRequestByIdTest() throws Exception {
		
		RequestCustomer requestCustomer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		RequestProduct requestProduct = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		Request request = CreateRequestFactoryTest.get("1", requestProduct, requestCustomer, 1, new BigDecimal(15D));
		
		ResponseEntity<Request> expect = new ResponseEntity<Request>(request, HttpStatus.OK);
		when(repository.getOne("1")).thenReturn(request);
		when(requestControllerservice.findRequestById("1")).thenReturn(expect);
		
		mockMvc.perform(get("/requests/1").header("client_id" , "SOMETOKEN")).andExpect(status().isOk());
		
	}
	
	
	
	@Test
	public void requestGetListRequestBadRequestTest() throws Exception {
		
		RequestCustomer requestCustomer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		RequestProduct requestProduct = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		Request request = CreateRequestFactoryTest.get("1", requestProduct, requestCustomer, 1, new BigDecimal(15D));
		
		List<Request> listRequest = new ArrayList<>();
		listRequest.add(request);
		
		ResponseEntity<List<Request>> expect = new ResponseEntity<List<Request>>(listRequest, HttpStatus.OK);
		when(repository.findAll()).thenReturn(listRequest);
		when(requestControllerservice.getListRequests("teste", null, null)).thenReturn(expect);
		
		mockMvc.perform(get("/requests")).andExpect(status().isBadRequest());
		
	}
	
	@Test
	public void requestPostRequestTest() throws Exception {
		
		RequestCustomer requestCustomer = CreateRequestCustomerFactoryTest.get("1", "Christian");
		
		RequestProduct requestProduct = CreateRequestProductFatoryTest.get("1", "Pendrive");
		
		Request request = CreateRequestFactoryTest.get("1", requestProduct, requestCustomer, 1, new BigDecimal(15D));
		
		ResponseEntity<Request> expect = new ResponseEntity<Request>(request, HttpStatus.OK);
		when(repository.save(request)).thenReturn(request);
		when(requestControllerservice.insertRequest(request)).thenReturn(expect);
		
		ObjectMapper mapper = new ObjectMapper();
	    String requestJson=mapper.writeValueAsString(request);
		
		mockMvc.perform(post("/requests").header("client_id" , "SOMETOKEN")
				.contentType(MediaType.APPLICATION_JSON).content(requestJson)
				).andExpect(status().isOk());
		
	}
}
