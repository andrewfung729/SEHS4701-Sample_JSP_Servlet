package edu.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "SignInServlet", value = "/signin")
public class SignInServlet extends HttpServlet {

    // simulate a very simple database
    private Map<String, String> users = Map.of("bob", "bob123", "alice", "alice123", "tom", "tomcat");

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
        super();
    }

    // display sign-in form
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String contextPath = request.getContextPath();
        pw.write("<h1>Sign In</h1>");
        pw.write("<form action=\"" + contextPath + "/signin\" method=\"post\">");
        pw.write("<p>Username: <input name=\"username\"></p>");
        pw.write("<p>Password: <input name=\"password\" type=\"password\"></p>");
        pw.write("<p><button type=\"submit\">Sign In</button> <a href=\"/\">Cancel</a></p>");
        pw.write("</form>");
        pw.flush();
    }

    // handle sign-in form
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contextPath = request.getContextPath();
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String expectedPassword = users.get(name);
        if (expectedPassword != null && expectedPassword.equals(password)) {
            // sign in successfully
            request.getSession().setAttribute("user", name);
            response.sendRedirect(contextPath + "/profile");
        } else {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}