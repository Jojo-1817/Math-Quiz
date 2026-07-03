package com.algonquin.capstone.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.algonquin.capstone.beans.ServiceTypes;
import com.algonquin.capstone.services.AuthenticationService;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        new AuthenticationService(request, response,
            ServiceTypes.USERLOGIN, userName, password);
    }
}