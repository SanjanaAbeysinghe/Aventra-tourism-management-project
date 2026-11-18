package com.aventra.model;

public class TourGuide extends User {
    public TourGuide(int id, String name, String email, String passwordHash, String phone) {
        super(id, name, email, passwordHash, phone);
    }
    @Override public String getRole() { return "GUIDE"; }
}
