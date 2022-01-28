<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
   String myPage = "index.jsp";
%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Password</title>

<link rel='stylesheet' href='webjars/bootstrap/4.6.1/css/bootstrap.min.css'>
<link rel='stylesheet' href='css/StyleSheet.css'>
<body>

<section id="cover" class="min-vh-100">
    <div id="cover-caption">
        <div class="container">
  
            <div class="row text-white">
     
                <div class="col-xl-5 col-lg-6 col-md-8 col-sm-10 mx-auto text-center form p-4">
                   <img src="img/logo.png" class="center">
                    <h1 class="display-4 py-2 text-truncate"></h1>
                    <div class="px-2">

                   			<p><h5 style="color:black;">Forget Password</h5></p>
                   	   <form action="ForgetServlet" method="post" class="justify-content-center">
                            <div class="form-group">
               					<h2 style="color:black;">Admin Login</h2>
               					
               					<h5 style="color:black;">Username</h5>
                                <label class="sr-only">Username</label>
                                <input type="text" class="form-control" placeholder="username" name="username">
                            </div>
                                      <div class="form-group">
                            	<h5 style="color:black;">New Password</h5>
                                <label class="sr-only">new Password</label>
                                <input type="password" class="form-control" placeholder="password" name="password">
                            </div>
                            
                            <button type="submit" class="btn btn-primary btn-lg">Reset</button>
                          <input type="button" class="btn btn-primary btn-lg" onClick="JavaScript:window.location='<%= myPage %>';"  value="Retun to Login Page">
                   
                        </form>
                           
            
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>