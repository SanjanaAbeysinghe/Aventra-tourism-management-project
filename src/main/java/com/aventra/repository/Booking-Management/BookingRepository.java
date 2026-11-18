package com.aventra.repository;

import com.aventra.db.DBConnection;
import com.aventra.model.Booking;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class BookingRepository {
    public Booking create(int customerId,int packageId,int guests,LocalDate date) throws SQLException {
        String sql="INSERT INTO bookings(customer_id,package_id,guests,travel_date,status) VALUES(?,?,?,?, 'PENDING')";
        try(Connection c=DBConnection.getConnection(); PreparedStatement ps=c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1,customerId); ps.setInt(2,packageId); ps.setInt(3,guests); ps.setDate(4,java.sql.Date.valueOf(date));
            ps.executeUpdate();
            try(ResultSet rs=ps.getGeneratedKeys()){
                if(rs.next()) return new Booking(rs.getInt(1),customerId,packageId,null,guests,date,"PENDING");
            }
        }
        throw new SQLException("Could not save booking.");
    }
    public List<Booking> findByCustomer(int customerId) throws SQLException {
        List<Booking> result=new ArrayList<>();
        String sql="SELECT * FROM bookings WHERE customer_id=? ORDER BY booking_id DESC";
        try(Connection c=DBConnection.getConnection(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,customerId);
            try(ResultSet rs=ps.executeQuery()){
                while(rs.next()){
                    java.sql.Date d=rs.getDate("travel_date");
                    result.add(new Booking(rs.getInt("booking_id"),rs.getInt("customer_id"),rs.getInt("package_id"),
                        (Integer)rs.getObject("guide_id"),rs.getInt("guests"),d.toLocalDate(),rs.getString("status")));
                }
            }
        }
        return result;
    }
}
