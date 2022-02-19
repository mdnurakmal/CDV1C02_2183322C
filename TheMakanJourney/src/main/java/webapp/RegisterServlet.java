package webapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException; 
import org.apache.commons.validator.routines.EmailValidator;
import java.io.PrintWriter; 

import java.sql.Connection; 

import java.sql.DriverManager; 

import java.sql.PreparedStatement; 
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html"); 
	
       	 boolean status = register(request.getParameter("username"),request.getParameter("password"),request.getParameter("email"),request.getParameter("language"));
	     if (status)
	    	 response.sendRedirect("registration_successful.jsp");
	     else
	    	 response.sendRedirect("registration_failed.jsp");
	       
	}
	
	public boolean register(String username,String passowrd,String email, String language)
	{
		  String n = username; 
	        String p = passowrd; 
	        String e = email; 
	        String c = language; 
	        
	
	        boolean valid = EmailValidator.getInstance().isValid(e);
	        if(!valid)
	        	return false;
	        
	        try { 

	            Class.forName("com.mysql.cj.jdbc.Driver"); 
	            Connection con = DriverManager.getConnection( "jdbc:mysql://34.125.93.145:6033/mavendb", "root", "my_secret_password"); 
	            PreparedStatement ps = con.prepareStatement("insert into userdetails values(?,?,?,?)"); 

	            ps.setString(1, n); 
	            ps.setString(2, e); 
	            ps.setString(3, p); 
	            ps.setString(4, c); 

	            int i = ps.executeUpdate(); 
	            if (i > 0) 
	            {
	            	 
	            	  return true;
	            }
	        }
	        catch (Exception e2) { 
	            System.out.println(e2); 
	            return false;
	        }   
	            return false;
	}


}
