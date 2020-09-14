/**
 * 
 */
package com.test.feel.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Christian Bernardino de Moura
 *
 * christiabmoura@gmail.com
 */
@Entity
@ApiModel(description = "Represents products offered at the store")
@Validated
public class Product {
	
	
	
	/**
	 * 
	 */
	public Product() {
		
	}

	@Id
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("value")
	private BigDecimal value;

	
	
	/**
	 * @param id
	 */
	public Product id(String id) {
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

	/**
	 * @param name
	 */
	public Product name(String name) {
		this.name = name;
		return this;
	}
	
	/**
	 * @return the name
	 */
	@ApiModelProperty(readOnly = true, value = "Product name")
	@Size(max=500)
	@NotEmpty
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param name
	 */
	public Product value(BigDecimal value) {
		this.value = value;
		return this;
	}
	
	/**
	 * @return the value
	 */
	@ApiModelProperty(readOnly = true, value = "Product value")
	@Valid
	@DecimalMin("0")
	@NotNull
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		return "Product [id=" + id + ", name=" + name + ", value=" + value + "]";
	}

	
}
