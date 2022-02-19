package test;
import junit.framework.TestCase;
import webapp.RegisterServlet;

import org.junit.Ignore;
import org.junit.Test;
import org.testng.Assert;

@Ignore
public class ServletTest extends TestCase {

	
	@Test
	public void testValidEmail() throws Exception {
		Assert.assertTrue(new RegisterServlet().register("student","student", "student@email.com", "english"));

	}
	
	@Test
	public void testInvalidEmail() throws Exception {
		Assert.assertFalse(new RegisterServlet().register("student","student", "student@@email..com", "english"));
	}
}
