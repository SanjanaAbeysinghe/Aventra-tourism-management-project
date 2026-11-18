package com.aventra.model;

public abstract class User {
    private int userId;
    private String name;
    private String email;
    private String passwordHash;
    private String phone;

    protected User(int userId, String name, String email, String passwordHash, String phone) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.phone = phone;
    }

    public abstract String getRole();

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override public String toString() { return name + " (" + email + ")"; }
}
