<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Response Object</title>
</head>
<body>
<center>
    <h2>Auto Refresh Header Example</h2>
    <%
        // Set refresh, autoload time as 5 seconds
        response.setIntHeader("Refresh", 5);
        // Get current time
        Calendar calendar = new GregorianCalendar();
        String am_pm;
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        if (calendar.get(Calendar.AM_PM) == Calendar.AM)
            am_pm = "AM";
        else
            am_pm = "PM";
        String CT = hour + ":" + minute + ":" + second + " " + am_pm;
        out.println("Current Time is: " + CT + "\n");
    %>
</center>
</body>
</html>