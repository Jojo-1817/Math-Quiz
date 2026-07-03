package com.algonquin.capstone.dao;

import java.sql.*;
import com.algonquin.capstone.model.User;
import com.algonquin.capstone.services.ApplicationService;

public class ApplicationDao implements ApplicationService {

    public ApplicationDao() {}

    @Override
    public boolean ValidateUserLogin(String userName, String password)
            throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getConnectionToDatabase();
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userName);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
    }

    @Override
    public boolean RegisterUser(String firstName, String lastName,
            String userName, String password)
            throws ClassNotFoundException, SQLException {
        // First check if already registered
        Connection conn = DBConnection.getConnectionToDatabase();
        String checkSql = "SELECT * FROM users WHERE email = ?";
        try (PreparedStatement check = conn.prepareStatement(checkSql)) {
            check.setString(1, userName);
            if (check.executeQuery().next()) return false; // already exists
        }
        // Insert new user
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, firstName + " " + lastName);
            stmt.setString(2, userName);
            stmt.setString(3, password);
            stmt.executeUpdate();
            return true;
        }
    }

    @Override
    public boolean PasswordReset(String username, String oldPassword,
            String newPassword, String confPassword) {
        if (!newPassword.equals(confPassword)) return false;
        try {
            Connection conn = DBConnection.getConnectionToDatabase();
            // Verify old password
            String checkSql = "SELECT * FROM users WHERE email=? AND password=?";
            try (PreparedStatement check = conn.prepareStatement(checkSql)) {
                check.setString(1, username);
                check.setString(2, oldPassword);
                if (!check.executeQuery().next()) return false;
            }
            // Update password
            String sql = "UPDATE users SET password=? WHERE email=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, newPassword);
                stmt.setString(2, username);
                stmt.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}