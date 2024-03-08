<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Parameter Processing:</title>
</head>
<body>
<h1>We have the parameters:</h1>
<ul>
    <li>
        <p>
            <b>1st Parameter:</b> <%=request.getParameter("p1")%>
        </p>
    </li>
    <li>
        <p>
            <b>2nd Parameter:</b> <%=request.getParameter("p2")%>
        </p>
    </li>
</ul>
</body>
</html>