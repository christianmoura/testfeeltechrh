/**
 * 
 */
package com.test.feel.domain;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Christian Bernardino de Moura
 *
 * christiabmoura@gmail.com
 */
@Validated
public class Error {
	
	
	
	/**
	 * 
	 */
	public Error() {
		
	}

	@JsonProperty("timestamp")
	private String timestamp;
	
	@JsonProperty("status")
	private Integer status;
	
	@JsonProperty("errors")
	@Valid
	private List<ErrorErrors> errors;

	public Error timestamp(String timestamp) {
	    this.timestamp = timestamp;
	    return this;
	}
	
	/**
	 * @return the timestamp
	 */
	@ApiModelProperty(value = "Timestamp")
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public Error status(Integer status) {
	    this.status = status;
	    return this;
	}

	/**
	 * @return the status
	 */
	@ApiModelProperty(value = "HTTP Status code")
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Error errors(List<ErrorErrors> errors) {
	    this.errors = errors;
	    return this;
	}
	
	public Error addErrorsItem(ErrorErrors errorsItem) {
	    if (this.errors == null) {
	      this.errors = new ArrayList<ErrorErrors>();
	    }
	    this.errors.add(errorsItem);
	    return this;
	}
	
	/**
	 * @return the erros
	 */
	@ApiModelProperty(value = "")
	@Valid
	public List<ErrorErrors> getErros() {
		return errors;
	}

	/**
	 * @param erros the erros to set
	 */
	public void setErros(List<ErrorErrors> erros) {
		this.errors = erros;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((errors == null) ? 0 : errors.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
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
		Error other = (Error) obj;
		if (errors == null) {
			if (other.errors != null)
				return false;
		} else if (!errors.equals(other.errors))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Error [timestamp=" + timestamp + ", status=" + status + ", errors=" + errors + "]";
	}

	
	
	
}
