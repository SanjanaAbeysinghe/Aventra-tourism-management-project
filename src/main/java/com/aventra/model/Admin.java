package com.aventra.model;

public class Admin extends User {
    public Admin(int id, String name, String email, String passwordHash, String phone) {
        super(id, name, email, passwordHash, phone);
    }
    @Override public String getRole() { return "ADMIN"; }
}
