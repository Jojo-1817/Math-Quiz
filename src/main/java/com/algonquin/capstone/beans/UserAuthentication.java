package com.algonquin.capstone.beans;

public class UserAuthentication {

    private String userEmail;
    private String userPassword;
    private boolean isAuthenticated;

    UserAuthentication(String email, String password) {
        this.userEmail = email;
        this.userPassword = password;
    }

    public String GetUserEmail()           { return this.userEmail; }
    public void   SetUserEmail(String e)   { this.userEmail = e; }
    public String GetUserPassword()        { return this.userPassword; }
    public void   SetUserPassword(String p){ this.userPassword = p; }
    public boolean IsAuthenticated()       { return this.isAuthenticated; }
    public void   SetIsAuthenticated(boolean f) { this.isAuthenticated = f; }
}