<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Action: UseBean</title>
</head>
<body>
<center>
    <h2>Using JavaBeans</h2>
    <jsp:useBean id="myBean" class="edu.sehs4701.SampleBean"/>
    <p>Got message....</p>
    <jsp:getProperty name="myBean" property="message"/>
    <jsp:setProperty name="myBean" property="message" value="Hello Bean..."/>
    <p>Got message....</p>
    <jsp:getProperty name="myBean" property="message"/>
</center>
</body>
</html>