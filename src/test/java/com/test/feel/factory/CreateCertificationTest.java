/**
 * 
 */
package com.test.feel.factory;

import com.test.feel.domain.Certification;


/**
 * @author Christian Bernardino de Moura
 *
 * christiabmoura@gmail.com
 */
public class CreateCertificationTest {
	public static Certification get(Long id, String description) {
		return new Certification() {
			{
				setId(id);
				setDescription(description);
			}
		};
	}
}
