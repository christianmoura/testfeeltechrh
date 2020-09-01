/**
 * 
 */
package com.test.feel.factory;

import com.test.feel.domain.Contact;

/**
 * @author Christian Bernardino de Moura
 *
 * christiabmoura@gmail.com
 */
public class CreateContactTest {
	public static Contact get(Long id, String mobileNumber, String email, String linkedin) {
		
		return new Contact() {
			{
				setId(id);
				setMobileNumber(mobileNumber);
				setEmail(email);
				setLinkedin(linkedin);
			}
		};
		
	}
}
