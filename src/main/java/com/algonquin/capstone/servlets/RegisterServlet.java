package com.algonquin.capstone.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.algonquin.capstone.beans.ServiceTypes;
import com.algonquin.capstone.services.AuthenticationService;

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstname");
        String lastName  = request.getParameter("lastname");
        String userName  = request.getParameter("username");
        String password  = request.getParameter("password");
        new AuthenticationService(request, response,
            ServiceTypes.USERREGISTER,
            firstName, lastName, userName, password);
    }
}