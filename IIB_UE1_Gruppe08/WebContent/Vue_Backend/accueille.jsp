<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Beans.Login"  %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%
            Login user=(Login) session.getAttribute("utilisateur");
    
    %>
    <a href="./Vue_Backend/logout.jsp"> Logout</a>
    <h1>information von Benutzer</h1>
    <pre>
       Login:     <%= user.getLogin() %>
       passeword: <%= user.getPassword() %>
    </pre>
</body>
</html>