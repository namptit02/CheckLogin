package com.example.checklogin.model;

public class Member {
    private int ID;
    private String Username;
    private String Password;
    private String FullName;
    private String Role;

    public Member() {
    }

    public Member(int ID, String username, String password, String fullName, String role) {
        this.ID = ID;
        Username = username;
        Password = password;
        FullName = fullName;
        Role = role;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }
    // Các getters và setters
}
