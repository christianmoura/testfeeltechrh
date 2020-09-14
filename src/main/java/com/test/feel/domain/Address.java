/**
 * 
 */
package com.test.feel.domain;

import javax.persistence.Entity;

import javax.persistence.Id;

import javax.validation.constraints.NotEmpty;
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
@ApiModel(description = "Represents the address of a customer")
@Validated
public class Address {

	
	
	/**
	 * 
	 */
	public Address() {
		
	}

	@Id
	@JsonProperty("id")
	private String id;
		
	@JsonProperty("street")
	private String street;
		
	@JsonProperty("neighborhood")
	private String neighborhood;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("province")
	private String province;

	
	
	/**
	 * @param id
	 */
	public Address id(String id) {
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

	public Address street(String street) {
	    this.street = street;
	    return this;
	}
	
	/**
	 * @return the street
	 */
	@ApiModelProperty(required = true, value = "Street and number description", example = "Rua Patagônia, Nº 150")
	@Size(max=500)
	@NotEmpty
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	public Address neighborhood(String neighborhood) {
	    this.neighborhood = neighborhood;
	    return this;
	}
	
	/**
	 * @return the neighborhood
	 */
	@ApiModelProperty(required = true, value = "Neighborhood")
	@Size(max=250)
	@NotEmpty
	public String getNeighborhood() {
		return neighborhood;
	}

	/**
	 * @param neighborhood the neighborhood to set
	 */
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public Address city(String city) {
	    this.city = city;
	    return this;
	}
	
	/**
	 * @return the city
	 */
	@ApiModelProperty(required = true, value = "City")
	@Size(max=250)
	@NotEmpty
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	public Address province(String province) {
	    this.province = province;
	    return this;
	}
	
	/**
	 * @return the province
	 */
	@ApiModelProperty(required = true, value = "Province")
	@Size(max=2)
	@NotEmpty
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((neighborhood == null) ? 0 : neighborhood.hashCode());
		result = prime * result + ((province == null) ? 0 : province.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
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
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (neighborhood == null) {
			if (other.neighborhood != null)
				return false;
		} else if (!neighborhood.equals(other.neighborhood))
			return false;
		if (province != other.province)
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", neighborhood=" + neighborhood + ", city=" + city
				+ ", province=" + province + "]";
	}

	
	
	
	
}
