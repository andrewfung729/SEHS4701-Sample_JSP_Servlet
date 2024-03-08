<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Application object in JSP</title></head>
<body>
<%
    Integer hitsCount = (Integer) application.getAttribute("hitCounter");
    if (hitsCount == null || hitsCount == 0) {
        /* First visit */
        out.println("Welcome to my website!");
        hitsCount = 1;
    } else {
        /* return visit */
        out.println("Welcome back to my website!");
        hitsCount += 1;
    }
    application.setAttribute("hitCounter", hitsCount);
%>
<p style="text-align:center;">
    Total number of visits: <%= hitsCount %>
</p></body>
</html>