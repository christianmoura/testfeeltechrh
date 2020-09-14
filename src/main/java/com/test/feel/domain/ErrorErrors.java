/**
 * 
 */
package com.test.feel.domain;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author christian
 *
 */
@Validated
public class ErrorErrors {
	
	
	
	/**
	 * 
	 */
	public ErrorErrors() {
		
	}

	@JsonProperty("code")
	private String code = null;

	@JsonProperty("description")
	private String description = null;
	
	public ErrorErrors code(String code) {
	    this.code = code;
	    return this;
	}

	/**
	 * @return the code
	 */
	@ApiModelProperty(value = "Error code")
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	public ErrorErrors description(String description) {
	    this.description = description;
	    return this;
	}
	
	/**
	 * @return the description
	 */
	@ApiModelProperty(value = "Error description")
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		ErrorErrors other = (ErrorErrors) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ErrorErrors [code=" + code + ", description=" + description + "]";
	}
	
	
	
}
