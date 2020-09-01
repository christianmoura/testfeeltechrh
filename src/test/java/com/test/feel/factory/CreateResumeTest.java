/**
 * 
 */
package com.test.feel.factory;

import java.util.Set;


import com.test.feel.domain.AcademicFormation;
import com.test.feel.domain.Certification;
import com.test.feel.domain.Contact;
import com.test.feel.domain.Experience;
import com.test.feel.domain.Resume;
import com.test.feel.domain.Skil;


/**
 * @author Christian Bernardino de Moura
 *
 * christiabmoura@gmail.com
 */
public class CreateResumeTest {
	public static Resume get(Long id, String name, Contact contact, Set<Skil> skils
			, Set<Certification> certifications, String apresentationShort
			, Set<Experience> experiences,Set<AcademicFormation> academicFormations) {
		return new Resume() {
			{
				setId(id);
				setName(name);
				setContact(contact);
				setSkils(skils);
				setCertifications(certifications);
				setApresentationShort(apresentationShort);
				setExperiences(experiences);
				setAcademicFormations(academicFormations);
			}
		};
	}
}
