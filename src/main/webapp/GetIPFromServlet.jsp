<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Response from Servlet</title>
</head>
<body>

<% if (request.getHeader("X-Forwarded-For") == null) { %>
<h1>Request from client</h1>
<% } %>

<p>
    Server data and time: <%=new Date()%>
</p>
<p>Your client IP address is = ${ipAddress}</p>

<% int i = 0; %>
<p>Using %: <%= ++i %></p>

<%! int j = 0; %>
<p>Using %!: <%= ++j %></p>

<%! static int k = 0; %>
<p>Using %! static: <%= ++k %></p>


</body>
</html>