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
@WebServlet("/ForgetServlet")
public class ForgetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetServlet() {
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
		 response.setContentType("text/html"); 
	        String n = request.getParameter("username"); 
	        String p = request.getParameter("password"); 
	        try { 
	            Class.forName("com.mysql.cj.jdbc.Driver"); 
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mavendb", "root", ""); 
	            String query = "SELECT * FROM userdetails";
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(query);
	            while (rs.next())
	            {
	              String username = rs.getString("username");

	              if (Objects.equals(n,username)) 
		            {
	            	  
	                  String query1 = "update USERDETAILS set password = ? where username = ?";
	                  PreparedStatement ps = con.prepareStatement(query1);
	                  ps.setString(1, p);
	                  ps.setString(2, username);
	                  
	                  ps.executeUpdate(); 
	            	  
	            	  response.sendRedirect("reset_successful.jsp");
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
