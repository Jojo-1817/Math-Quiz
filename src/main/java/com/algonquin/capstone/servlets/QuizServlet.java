package com.algonquin.capstone.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class QuizServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("username");
        request.setAttribute("username", userName);
        request.getRequestDispatcher("/quiz.jsp")
               .forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}