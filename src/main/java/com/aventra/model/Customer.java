package com.aventra.model;

public class Customer extends User {
    public Customer(int id, String name, String email, String passwordHash, String phone) {
        super(id, name, email, passwordHash, phone);
    }
    @Override public String getRole() { return "CUSTOMER"; }
}
