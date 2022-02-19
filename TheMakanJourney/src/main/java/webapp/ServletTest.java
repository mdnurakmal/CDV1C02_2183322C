package webapp;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
