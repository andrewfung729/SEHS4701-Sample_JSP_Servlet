package edu.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "LanguageServlet", value = "/preferences")
public class LanguageServlet extends HttpServlet {
    private static final Set<String> LANGUAGES = Set.of("en", "zh");

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LanguageServlet() {
        super();
    }

    public static String parseLanguageFromCookie(HttpServletRequest request) {
        String language = null;
        if (request.getCookies() != null) {
            for (var cookie : request.getCookies()) {
                if ("lang".equals(cookie.getName())) {
                    language = cookie.getValue();
                    break;
                }
            }
        }
        return language;
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest, HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contextPath = request.getContextPath();
        String language = request.getParameter("lang");
        if (language == null) {
            response.sendRedirect(contextPath + "/profile");
        }

        if (LANGUAGES.contains(language)) {
            Cookie cookie = new Cookie("lang", language);
            cookie.setMaxAge(30 * 24 * 60 * 60); // 30 days
            cookie.setPath(contextPath);
            response.addCookie(cookie);
        }
        response.sendRedirect(contextPath + "/profile");
    }
}