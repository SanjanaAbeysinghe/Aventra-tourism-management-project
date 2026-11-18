package com.aventra.service;
import com.aventra.exception.*; import com.aventra.model.Booking; import com.aventra.repository.BookingRepository; import java.sql.SQLException; import java.time.LocalDate; import java.util.List;
public class BookingService implements BookingOperations {
 private final BookingRepository repository; public BookingService(BookingRepository repository){this.repository=repository;}
 public Booking book(int customerId,int packageId,int guests,LocalDate date)throws ValidationException,DatabaseException{
  if(guests<1||guests>20)throw new ValidationException("Guests must be between 1 and 20.");if(date==null||!date.isAfter(LocalDate.now()))throw new ValidationException("Choose a future travel date.");
  try{return repository.create(customerId,packageId,guests,date);}catch(SQLException e){throw new DatabaseException("Booking could not be saved. Check the package and database.",e);}
 }
 public List<Booking> getCustomerBookings(int customerId)throws DatabaseException{try{return repository.findByCustomer(customerId);}catch(SQLException e){throw new DatabaseException("Could not retrieve your bookings.",e);}}
}
