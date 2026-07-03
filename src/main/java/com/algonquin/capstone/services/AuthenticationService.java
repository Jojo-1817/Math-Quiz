package com.algonquin.capstone.services;

import java.io.*;
import java.sql.SQLException;
import java.text.MessageFormat;
import javax.servlet.http.*;
import com.algonquin.capstone.beans.ServiceTypes;
import com.algonquin.capstone.dao.ApplicationDao;

public class AuthenticationService {

    // ── Login constructor ──
    public AuthenticationService(HttpServletRequest request,
            HttpServletResponse response, ServiceTypes service,
            String userName, String password) {
        if (service == ServiceTypes.USERLOGIN)
            UserLogin(request, response, userName, password);
    }

    // ── Register constructor ──
    public AuthenticationService(HttpServletRequest request,
            HttpServletResponse response, ServiceTypes service,
            String firstName, String lastName,
            String userName, String password) {
        if (service == ServiceTypes.USERREGISTER)
            UserRegistration(request, response, firstName, lastName, userName, password);
    }

    // ── Password reset constructor ──
    public AuthenticationService(HttpServletRequest request,
            HttpServletResponse response, ServiceTypes service,
            String username, String oldPassword,
            String newPassword, String confPassword, int flag) {
        if (service == ServiceTypes.PASSWORDRESET) {
            try { PasswordReset(request, response, username, oldPassword, newPassword, confPassword); }
            catch (SQLException e) { e.printStackTrace(); }
        }
    }

    // ── UserLogin ──
    public void UserLogin(HttpServletRequest request,
            HttpServletResponse response, String userName, String password) {
        ApplicationDao dao = new ApplicationDao();
        boolean isAuthenticated = false;
        try { isAuthenticated = dao.ValidateUserLogin(userName, password); }
        catch (Exception e) { e.printStackTrace(); }

        try {
            if (!isAuthenticated) {
                String page = DisplayMessageBelowPage(
                    request.getServletContext().getRealPath("index.html"),
                    "<br>Invalid email or password!", 0);
                response.getWriter().write(page);
            } else {
                String welcome = LoadHtmlToString(
                    request.getServletContext().getRealPath("welcome.html"));
                String page = DisplayMessageBelowPage(
                    request.getServletContext().getRealPath("index.html"),
                    welcome, 0);
                page = MessageFormat.format(page, userName, 0);
                response.getWriter().write(page);
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    // ── UserRegistration ──
    public void UserRegistration(HttpServletRequest request,
            HttpServletResponse response, String firstName, String lastName,
            String userName, String password) {
        ApplicationDao dao = new ApplicationDao();
        boolean isRegistered = false;
        try { isRegistered = dao.RegisterUser(firstName, lastName, userName, password); }
        catch (Exception e) { e.printStackTrace(); }
        try {
            String msg = isRegistered
                ? "User [" + userName + "] successfully registered!"
                : "User [" + userName + "] is already registered!";
            String page = DisplayMessageBelowPage(
                request.getServletContext().getRealPath("index.html"), msg, 4);
            response.getWriter().write(page);
        } catch (IOException e) { e.printStackTrace(); }
    }

    // ── PasswordReset ──
    public void PasswordReset(HttpServletRequest request,
            HttpServletResponse response, String username,
            String oldPassword, String newPassword,
            String confPassword) throws SQLException {
        ApplicationDao dao = new ApplicationDao();
        boolean ok = dao.PasswordReset(username, oldPassword, newPassword, confPassword);
        try {
            String msg = ok ? "Password was reset successfully!"
                            : "Password reset failed, try again!";
            String page = DisplayMessageBelowPage(
                request.getServletContext().getRealPath("index.html"), msg, 4);
            response.getWriter().write(page);
        } catch (IOException e) { e.printStackTrace(); }
    }

    // ── Helpers ──
    public String LoadHtmlToString(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) sb.append(line);
        reader.close();
        return sb.toString();
    }

    public String DisplayMessageBelowPage(String filePath, String msg,
            int headerLevel) throws IOException {
        String page = LoadHtmlToString(filePath);
        String tag = headerLevel == 0 ? "div" : "h" + headerLevel;
        return page + "<" + tag +
            " style=\"text-align:center;color:Tomato;\">" +
            msg + "</" + tag + ">";
    }
}