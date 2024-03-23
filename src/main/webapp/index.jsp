<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Quick Tutorial about JSP and Servlet</title></head>
<body>
Your computer local address: <br/>
(Using JSP)
<div id="AddressFromJSP">
    <p>
        <%
            out.println("Your client IP address is = " + request.getRemoteAddr());
        %>
    </p>
</div>
(Using Servlet)
<div id="IPAddressFromServlet">
    <a href="${pageContext.request.contextPath}/NetworkService">Get IP From Servlet</a>
</div>
</body>
</html>