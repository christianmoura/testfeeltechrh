/**
 * 
 */
package com.test.feel.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Christian Bernardino de Moura
 *
 * christianbmoura@gmail.com
 */

@Entity
@ApiModel(description = "Represents a request of products")
@Validated
public class Request {
	
	
	
	/**
	 * 
	 */
	public Request() {
		
	}

	@Id
	@JsonProperty("id")
	private String id;

	@ManyToOne
	@JsonProperty("product")
	private RequestProduct product;

	@ManyToOne
	@JsonProperty("customer")
	private RequestCustomer customer;

	@JsonProperty("amount")
	private Integer amount;

	@JsonProperty("value")
	private BigDecimal value;

	
	
	public Request id(String id) {
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

	public Request product(RequestProduct product) {
	    this.product = product;
	    return this;
	}
	
	/**
	 * @return the product
	 */
	
	@ApiModelProperty(required = true, value = "")
    @NotNull
    @Valid
	public RequestProduct getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(RequestProduct product) {
		this.product = product;
	}

	public Request customer(RequestCustomer customer) {
	    this.customer = customer;
	    return this;
	}
	
	/**
	 * @return the customer
	 */
	@ApiModelProperty(required = true, value = "")
    @NotNull
    @Valid
	public RequestCustomer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(RequestCustomer customer) {
		this.customer = customer;
	}

	public Request amount(Integer amount) {
	    this.amount = amount;
	    return this;
	}
	
	/**
	 * @return the amount
	 */
	@ApiModelProperty(required = true, value = "Product amount of the request")
    @NotNull
	@Min(1)
	@Max(10)
	public Integer getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Request value(BigDecimal value) {
	    this.value = value;
	    return this;
	}
	
	/**
	 * @return the value
	 */
	@ApiModelProperty(required = true, value = "Value of the request")
    @NotNull
    @Valid
    @DecimalMin("0") 
	public BigDecimal getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(BigDecimal value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", product=" + product + ", customer=" + customer + ", amount=" + amount
				+ ", value=" + value + "]";
	}
	
	
	
}
