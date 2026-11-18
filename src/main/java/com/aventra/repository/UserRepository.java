package com.aventra.repository;

import com.aventra.db.DBConnection;
import com.aventra.model.*;
import java.sql.*;

public class UserRepository {
    public User findByEmail(String email) throws SQLException {
        String sql="SELECT * FROM users WHERE email=?";
        try(Connection c=DBConnection.getConnection(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setString(1,email);
            try(ResultSet rs=ps.executeQuery()){
                if(!rs.next()) return null;
                return map(rs);
            }
        }
    }
    public User create(String name,String email,String passwordHash,String phone) throws SQLException {
        String sql="INSERT INTO users(name,email,password_hash,phone,role) VALUES(?,?,?,?, 'CUSTOMER')";
        try(Connection c=DBConnection.getConnection(); PreparedStatement ps=c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1,name); ps.setString(2,email); ps.setString(3,passwordHash); ps.setString(4,phone);
            ps.executeUpdate();
            try(ResultSet keys=ps.getGeneratedKeys()){
                if(keys.next()) return new Customer(keys.getInt(1),name,email,passwordHash,phone);
            }
        }
        throw new SQLException("Could not create user.");
    }
    private User map(ResultSet rs) throws SQLException {
        int id=rs.getInt("user_id"); String role=rs.getString("role");
        String name=rs.getString("name"), email=rs.getString("email"), hash=rs.getString("password_hash"), phone=rs.getString("phone");
        return switch(role){
            case "ADMIN" -> new Admin(id,name,email,hash,phone);
            case "GUIDE" -> new TourGuide(id,name,email,hash,phone);
            default -> new Customer(id,name,email,hash,phone);
        };
    }
}
