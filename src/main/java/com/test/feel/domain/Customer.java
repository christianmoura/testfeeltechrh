/**
 * 
 */
package com.test.feel.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.feel.domain.enums.Status;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Christian Bernardino de Moura
 *
 * christianbmoura@gmail.com
 */

@Entity
@ApiModel(description = "Represents a customer who purchases products")
@Validated
public class Customer {

	
	
	/**
	 * 
	 */
	public Customer() {
		
	}

	@Id
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("name")
	private String name = null;

	@ManyToOne
	@JsonProperty("address")
	private Address address = null;

	@OneToMany
	@JsonProperty("requests")
	@Valid
	private List<Request> requests = null;

	@JsonProperty("status")
	private Status status = null;

	public Customer id(String id) {
	    this.id = id;
	    return this;
	}

	/**
	 * @return the id
	 */
	@ApiModelProperty(readOnly = true, value = "Unique identifier")
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	public Customer name(String name) {
	    this.name = name;
	    return this;
	}
	
	/**
	 * @return the name
	 */
	@ApiModelProperty(required = true, value = "Customer name")
    @NotNull
	@Size(min=10, max=500)
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Customer address(Address address) {
	    this.address = address;
	    return this;
	}
	
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	public Customer requests(List<Request> requests) {
	    this.requests = requests;
	    return this;
	}
	
	/**
	 * @return the requests
	 */
	public List<Request> getRequests() {
		return requests;
	}

	/**
	 * @param requests the requests to set
	 */
	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public Customer status(Status status) {
	    this.status = status;
	    return this;
	}
	
	/**
	 * @return the status
	 */
	
	@ApiModelProperty(value = "")	  
    @Valid
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	
	
	
	
}
