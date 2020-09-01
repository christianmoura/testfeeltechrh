/**
 * 
 */
package com.test.feel.factory;

import com.test.feel.domain.Skil;


/**
 * @author Christian Bernardino de Moura
 *
 * christiabmoura@gmail.com
 */
public class CreateSkilTest {
	public static Skil get(Long id, String description) {
		return new Skil() {
			{
				setId(id);
				setDescription(description);
			}
		};
	}
}
