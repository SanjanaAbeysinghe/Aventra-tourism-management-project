package com.aventra.service;

import com.aventra.exception.DatabaseException;
import com.aventra.exception.ValidationException;
import com.aventra.model.Booking;
import java.time.LocalDate;
import java.util.List;

/** Contract for booking operations; keeps the UI independent of implementation details. */
public interface BookingOperations {
    Booking book(int customerId, int packageId, int guests, LocalDate travelDate)
            throws ValidationException, DatabaseException;
    List<Booking> getCustomerBookings(int customerId) throws DatabaseException;
}
