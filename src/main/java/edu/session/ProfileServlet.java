package edu.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static edu.cookie.LanguageServlet.parseLanguageFromCookie;

@WebServlet(name = "ProfileServlet", value = "/profile")
public class ProfileServlet extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest, HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contextPath = request.getContextPath();
        String user = (String) request.getSession().getAttribute("user");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        pw.write("<h1>Welcome, " + (user != null ? user : "Guest") + "</h1>");
        if (user == null) {
            pw.write("<p><a href=\"" + contextPath + "/signin\">Sign In</a></p>");
            pw.flush();
            return;
        }

        pw.write("<p><a href=\"" + contextPath + "/signout\">Sign Out</a></p>");
        pw.write("<form action=\"" + contextPath + "/preferences\" method=\"post\">");
        pw.write("<p><input type=\"radio\" name=\"lang\" value=\"zh\"> 中文</p>");
        pw.write("<p><input type=\"radio\" name=\"lang\" value=\"en\"> English</p>");
        pw.write("<p><button type=\"submit\">Save</button></p>");

        String language = parseLanguageFromCookie(request);
        if ("zh".equals(language)) {
            pw.write("<p>語言：中文</p>");
        } else if ("en".equals(language)) {
            pw.write("<p>Language: English</p>");
        }
        pw.flush();
    }
}