package com.algonquin.capstone.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.algonquin.capstone.beans.ServiceTypes;
import com.algonquin.capstone.services.AuthenticationService;

public class PasswordResetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String username    = request.getParameter("username");
        String oldPassword = request.getParameter("oldpassword");
        String newPassword = request.getParameter("newpassword");
        String confPassword= request.getParameter("confpassword");
        new AuthenticationService(request, response,
            ServiceTypes.PASSWORDRESET,
            username, oldPassword, newPassword, confPassword, 0);
    }
}