<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display Sum</title>
</head>
<body>
<h1>
    <%
        String number1 = request.getParameter("n1");
        String number2 = request.getParameter("n2");
        try {
            int intNum1 = Integer.parseInt(number1);
            int intNum2 = Integer.parseInt(number2);
            out.println("Sum: " + (intNum1 + intNum2));
        } catch (NumberFormatException e) {
            out.println("Error: " + e.getMessage());
        }
    %>
</h1>
</body>
</html>
