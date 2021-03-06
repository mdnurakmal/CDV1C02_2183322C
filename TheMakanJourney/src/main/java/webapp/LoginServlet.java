package webapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException; 
import java.sql.*;
import java.io.PrintWriter; 

import java.sql.Connection; 

import java.sql.DriverManager; 

import java.sql.PreparedStatement;
import java.util.Objects; 
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
	        String n = request.getParameter("username"); 
	        String p = request.getParameter("password"); 
	        try { 

	            Class.forName("com.mysql.jdbc.Driver"); 
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mavendb", "root", ""); 
	            // if you only need a few columns, specify them by name instead of using "*"
	            String query = "SELECT * FROM userdetails";

	            // create the java statement
	            Statement st = con.createStatement();
	            
	            // execute the query, and get a java resultset
	            ResultSet rs = st.executeQuery(query);
	            
	            // iterate through the java resultset
	            while (rs.next())
	            {
	              String username = rs.getString("username");
	              String password = rs.getString("password");

	              if (Objects.equals(n,username) && Objects.equals(p,password)) 
		            {
	            	  response.sendRedirect("admin_dashboard.jsp");
	                  st.close();
	                  return;
		            }
	            }
	            response.sendRedirect("login_failed.jsp");
	            st.close();
	            
	        } catch (Exception e2) { 
	            System.out.println(e2); 
	        } 

	}

}
