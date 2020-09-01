/**
 * 
 */
package com.test.feel.factory;

import java.util.Date;

import com.test.feel.domain.Experience;


/**
 * @author Christian Bernardino de Moura
 *
 * christiabmoura@gmail.com
 */
public class CreateExperienceTest {
	public static Experience get(Long id, String company, String jobRole, Date dateStart
			, Date dateFinish, Boolean actualJob, String jobCity, String workDescription) {
		return new Experience() {
			{
				setId(id);
				setCompany(company);
				setJobRole(jobRole);
				setDateStart(dateStart);
				setDateFinish(dateFinish);
				setActualJob(actualJob);
				setJobCity(jobCity);
				setWorkDescription(workDescription);
			}
		};
	}
}
