package br.com.meta.validate.mail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

public class MailTest  {
	
	@Test
	public void validAddressEmail() {
		Assert.assertEquals(true,isValidEmailAddressRegex("nilson.andre@gmail.com"));
		Assert.assertEquals(true,isValidEmailAddressRegex("nilson.andregmail.com"));
	}


	public static boolean isValidEmailAddressRegex(String email) {
        boolean isEmailValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailValid = true;
            }
        }
        return isEmailValid;
    }
	
}


