/**
 * 
 */
package com.test.feel.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
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
@ApiModel(description = "Product of the request")
@Validated
public class RequestProduct {

	
	
	  /**
	 * 
	 */
	public RequestProduct() {
		
	}

	@Id
	  @JsonProperty("id")
	  private String id;

	  @JsonProperty("name")
	  private String name;

	  public RequestProduct id(String id) {
	    this.id = id;
	    return this;
	  }

	/**
	 * @return the id
	 */
	@ApiModelProperty(required = true, value = "Unique identifier")
    @NotNull
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	 public RequestProduct name(String name) {
		    this.name = name;
		    return this;
	 }
	
	/**
	 * @return the name
	 */
	@ApiModelProperty(readOnly = true, value = "Product name")
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		RequestProduct other = (RequestProduct) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return "RequestProduct [id=" + id + ", name=" + name + "]";
	}
	
	  
	  
}
