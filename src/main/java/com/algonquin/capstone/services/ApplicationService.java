package com.algonquin.capstone.services;

import java.sql.SQLException;

public interface ApplicationService {
    boolean ValidateUserLogin(String userName, String password)
        throws ClassNotFoundException, SQLException;
    boolean RegisterUser(String firstName, String lastName,
        String userName, String password)
        throws ClassNotFoundException, SQLException;
    boolean PasswordReset(String username, String oldPassword,
        String newPassword, String confPassword);
}