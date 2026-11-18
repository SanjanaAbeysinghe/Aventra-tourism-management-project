package com.aventra.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {
    private int paymentId, bookingId;
    private BigDecimal amount;
    private String method, status;
    private LocalDateTime paymentDate;

    public Payment(int paymentId,int bookingId,BigDecimal amount,String method,String status,LocalDateTime paymentDate){
        this.paymentId=paymentId; this.bookingId=bookingId; this.amount=amount;
        this.method=method; this.status=status; this.paymentDate=paymentDate;
    }
    public int getPaymentId(){return paymentId;}
    public int getBookingId(){return bookingId;}
    public BigDecimal getAmount(){return amount;}
    public String getMethod(){return method;}
    public String getStatus(){return status;}
    public LocalDateTime getPaymentDate(){return paymentDate;}
}
