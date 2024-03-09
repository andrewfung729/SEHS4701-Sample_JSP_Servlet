package edu.sehs4701;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalSum", value = "/CalSum")
public class CalSum extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest, HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String number1 = request.getParameter("n1");
        String number2 = request.getParameter("n2");
        try {
            int intNum1 = Integer.parseInt(number1);
            int intNum2 = Integer.parseInt(number2);
            out.println("Sum: " + (intNum1 + intNum2));
        } catch (NumberFormatException e) {
            out.println("Error: " + e.getMessage());
        }
    }
}