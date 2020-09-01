/**
 * 
 */
package com.test.feel.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Christian Bernardino de Moura
 *
 * christiabmoura@gmail.com
 */

@Entity
public class Experience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	@ApiModelProperty(notes = "Id", example="1")
	private Long id;
	
	@ApiModelProperty(notes = "Company name", example="Feel Tech RH")
	private String company;
	
	@ApiModelProperty(notes = "Job role", example="System Developer Senior")
	private String jobRole;
	
	@ApiModelProperty(notes = "Date start", example="System Developer Senior")
	private Date dateStart;
	
	@ApiModelProperty(notes = "Date finish", example="System Developer Senior")
	private Date dateFinish;
	
	@ApiModelProperty(notes = "Is actual Job", example="true")
	private Boolean actualJob;
	
	@ApiModelProperty(notes = "Job city", example="Porto Alegre - RS")
	private String jobCity;
	
	@ApiModelProperty(notes = "Work description", example="In my job develop microservices with java language")
	private String workDescription;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * @return the jobRole
	 */
	public String getJobRole() {
		return jobRole;
	}
	/**
	 * @param jobRole the jobRole to set
	 */
	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}
	/**
	 * @return the dateStart
	 */
	public Date getDateStart() {
		return dateStart;
	}
	/**
	 * @param dateStart the dateStart to set
	 */
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	/**
	 * @return the dateFinish
	 */
	public Date getDateFinish() {
		return dateFinish;
	}
	/**
	 * @param dateFinish the dateFinish to set
	 */
	public void setDateFinish(Date dateFinish) {
		this.dateFinish = dateFinish;
	}
	/**
	 * @return the actualJob
	 */
	public Boolean getActualJob() {
		return actualJob;
	}
	/**
	 * @param actualJob the actualJob to set
	 */
	public void setActualJob(Boolean actualJob) {
		this.actualJob = actualJob;
	}
	/**
	 * @return the jobCity
	 */
	public String getJobCity() {
		return jobCity;
	}
	/**
	 * @param jobCity the jobCity to set
	 */
	public void setJobCity(String jobCity) {
		this.jobCity = jobCity;
	}
	/**
	 * @return the workDescription
	 */
	public String getWorkDescription() {
		return workDescription;
	}
	/**
	 * @param workDescription the workDescription to set
	 */
	public void setWorkDescription(String workDescription) {
		this.workDescription = workDescription;
	} 
	
	
	
}
