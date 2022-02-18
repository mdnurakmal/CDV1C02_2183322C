package webapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException; 

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
	        String n = request.getParameter("username"); 
	        String p = request.getParameter("password"); 
	        String e = request.getParameter("email"); 
	        String c = request.getParameter("language"); 
	        try { 

	            Class.forName("com.mysql.cj.jdbc.Driver"); 
	            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mavendb", "root", ""); 
	            PreparedStatement ps = con.prepareStatement("insert into USERDETAILS values(?,?,?,?)"); 

	            ps.setString(1, n); 
	            ps.setString(2, e); 
	            ps.setString(3, p); 
	            ps.setString(4, c); 

	            int i = ps.executeUpdate(); 
	            if (i > 0) 
	            {
	            	  response.sendRedirect("registration_successful.jsp");
	            }
	            
	        } catch (Exception e2) { 
	            System.out.println(e2); 
	        } 
	}

}
