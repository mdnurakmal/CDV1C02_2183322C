
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import webapp.RegisterServlet;

import org.junit.Ignore;
import org.testng.Assert;

public class TestServlet {

	
	@Test
	public void testValidEmail() throws Exception {
		AssertJUnit.assertTrue(new RegisterServlet().register("student","student", "student@email.com", "english"));

	}
	
	@Test
	public void testInvalidEmail() throws Exception {
		AssertJUnit.assertFalse(new RegisterServlet().register("student","student", "student@@email..com", "english"));
	}
}
