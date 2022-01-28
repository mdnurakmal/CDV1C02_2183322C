<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Failed</title>

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
    
                   			<h5 style="color:black;">Admin username or password is invalid</h5>
                   			<form action="index.jsp">
							    <button type="submit" class="btn btn-primary btn-lg">Return to Login Page</button>
							</form>
                           
            
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>