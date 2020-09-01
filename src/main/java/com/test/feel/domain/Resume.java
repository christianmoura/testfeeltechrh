/**
 * 
 */
package com.test.feel.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Christian Bernardino de Moura
 *
 * christiabmoura@gmail.com
 */

@Entity
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	@ApiModelProperty(notes = "Id", example="1")
	private Long id;
	@ApiModelProperty(notes = "Name", example="Christian Bernardino de Moura")
	private String name;
	@OneToOne
	@ApiModelProperty(notes = "Contact data")
	private Contact contact;
	@OneToMany
	@ApiModelProperty(notes = "Skil list")
	private Set<Skil> skils;
	@OneToMany
	@ApiModelProperty(notes = "Certification list")
	private Set<Certification> certifications;
	@ApiModelProperty(notes = "Apresentation Short", example="I am system developer senior")
	private String apresentationShort;
	@OneToMany
	@ApiModelProperty(notes = "Experience list")
	private Set<Experience> experiences;
	@OneToMany
	@ApiModelProperty(notes = "Academic Formation list")
	private Set<AcademicFormation> academicFormations;
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
	 * @return the name
	 */
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
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	/**
	 * @return the skils
	 */
	public Set<Skil> getSkils() {
		return skils;
	}
	/**
	 * @param skils the skils to set
	 */
	public void setSkils(Set<Skil> skils) {
		this.skils = skils;
	}
	/**
	 * @return the certifications
	 */
	public Set<Certification> getCertifications() {
		return certifications;
	}
	/**
	 * @param certifications the certifications to set
	 */
	public void setCertifications(Set<Certification> certifications) {
		this.certifications = certifications;
	}
	/**
	 * @return the apresentationShort
	 */
	public String getApresentationShort() {
		return apresentationShort;
	}
	/**
	 * @param apresentationShort the apresentationShort to set
	 */
	public void setApresentationShort(String apresentationShort) {
		this.apresentationShort = apresentationShort;
	}
	/**
	 * @return the experiences
	 */
	public Set<Experience> getExperiences() {
		return experiences;
	}
	/**
	 * @param experiences the experiences to set
	 */
	public void setExperiences(Set<Experience> experiences) {
		this.experiences = experiences;
	}
	/**
	 * @return the academicFormations
	 */
	public Set<AcademicFormation> getAcademicFormations() {
		return academicFormations;
	}
	/**
	 * @param academicFormations the academicFormations to set
	 */
	public void setAcademicFormations(Set<AcademicFormation> academicFormations) {
		this.academicFormations = academicFormations;
	}
	
	
}
