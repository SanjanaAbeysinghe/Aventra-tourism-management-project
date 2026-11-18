package com.aventra.service;

import com.aventra.db.DBConnection;
import java.math.BigDecimal;
import java.sql.*;

public class PaymentService {
    public void recordPayment(int bookingId,BigDecimal amount,String method) throws SQLException {
        if(amount==null || amount.signum()<=0) throw new IllegalArgumentException("Payment must be greater than zero.");
        String sql="INSERT INTO payments(booking_id,amount,method,status) VALUES(?,?,?,'PAID')";
        try(Connection c=DBConnection.getConnection(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,bookingId); ps.setBigDecimal(2,amount); ps.setString(3,method); ps.executeUpdate();
        }
    }
}
