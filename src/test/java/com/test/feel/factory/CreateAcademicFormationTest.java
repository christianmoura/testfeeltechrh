/**
 * 
 */
package com.test.feel.factory;

import com.test.feel.domain.AcademicFormation;


/**
 * @author Christian Bernardino de Moura
 *
 * christiabmoura@gmail.com
 */


public class CreateAcademicFormationTest {

	public static AcademicFormation get(Long id, String univercity, String course
			, Integer yearStart, Integer yearFinish) {
		return new AcademicFormation() {
			{
				setId(id);
				setUnivercity(univercity);
				setCourse(course);
				setYearStart(yearStart);
				setYearFinish(yearFinish);
			}
		};
	
	}
}