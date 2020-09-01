/**
 * 
 */
package com.test.feel.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Christian Bernardino de Moura
 *
 * christiabmoura@gmail.com
 */

@Entity
@ApiModel(description = "Academic Formation entity")
public class AcademicFormation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	@ApiModelProperty(notes = "Id", example="1")
	private Long id;
	@ApiModelProperty(notes = "University", example="Centro Universitário Luterano de Manaus")
	private String univercity;
	@ApiModelProperty(notes = "Course", example="Sistemas de Informação")
	private String course;
	@ApiModelProperty(notes = "Year start", example="2007")
	private Integer yearStart;
	@ApiModelProperty(notes = "Year finish", example="2011")
	private Integer yearFinish;
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
	 * @return the univercity
	 */
	public String getUnivercity() {
		return univercity;
	}
	/**
	 * @param univercity the univercity to set
	 */
	public void setUnivercity(String univercity) {
		this.univercity = univercity;
	}
	/**
	 * @return the course
	 */
	public String getCourse() {
		return course;
	}
	/**
	 * @param course the course to set
	 */
	public void setCourse(String course) {
		this.course = course;
	}
	/**
	 * @return the yearStart
	 */
	public Integer getYearStart() {
		return yearStart;
	}
	/**
	 * @param yearStart the yearStart to set
	 */
	public void setYearStart(Integer yearStart) {
		this.yearStart = yearStart;
	}
	/**
	 * @return the yearFinish
	 */
	public Integer getYearFinish() {
		return yearFinish;
	}
	/**
	 * @param yearFinish the yearFinish to set
	 */
	public void setYearFinish(Integer yearFinish) {
		this.yearFinish = yearFinish;
	}
	
	
	
}
