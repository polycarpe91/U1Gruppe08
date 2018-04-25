<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
<link rel="stylesheet" href="css/style.css">
</head>
 <body>
  <section class="container">
    <div class="login">
      <h1>Login to Web App</h1>
      <form methode="post" action="Connection">
			<p><input type="text" name="login" value="" placeholder="Username"></p>
			<p><input type="password" name="password" value="" placeholder="Password"></p>
            <p><input type="submit" value="Submit"></p>
      </form>
 	</div>
     <div class="login-help">
      <p>Forgot your password? <a href="index.html">Click here to reset it</a>.</p>
    </div>
  </section>
  

  <section class="about">
    <p class="about-links">
      <a href="aboutUs.html" target="_parent">About US</a>
    </p>
    <p class="about-author">
      Informatik im Bau- und Umweltwesen 2 - Übung 1  </p>
      <p style="font-weight:300">&copy; 2018 <a href="shervin.html">Shervin Davarifard </a>and <a href="polycarpe.html">Polycarpe Tiomela</a> </p>
  </section>
</body>
</html>