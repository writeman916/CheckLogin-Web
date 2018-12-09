<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page language="java" import="java.util.ArrayList" %>
<%@ page language="java" import="model.bean.User" %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
   <table>
    <%
    	User userInfo = (User) request.getAttribute("userInfo");
    
    %>
          <tr>
             <td><%= userInfo.getName()%></td>
             <td><%= userInfo.getAddress()%></td>
             <td><%= userInfo.isMan() %></td>
          </tr>   
    </table>
</body>
</html>