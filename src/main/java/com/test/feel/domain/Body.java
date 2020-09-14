/**
 * 
 */
package com.test.feel.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.feel.domain.enums.Status;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Christian Bernardino de Moura
 *
 * christianbmoura@gmail.com
 */
@Validated
public class Body {
	
	
	
	/**
	 * 
	 */
	public Body() {
		
	}

	@JsonProperty("status")
	private Status status;

	public Body status(Status status) {
	    this.status = status;
	    return this;
	  }

	/**
	 * @return the status
	 */
	@ApiModelProperty(required = true, value = "")
    @NotNull
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Body other = (Body) obj;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Body [status=" + status + "]";
	}
	
	
	
}
