package com.aventra.model;
import java.math.BigDecimal;
public class AdventurePackage extends TourismPackage {
 public AdventurePackage(
         int id,
         int destinationId,
         String name,
         String category,
         String description,
         int days,
         BigDecimal price,
         int maxGuests,
         String itinerary,
         String accommodation,
         String transport,
         String meals,
         String difficulty,
         String bestSeason,
         String inclusions,
         String exclusions)
 {super(
         id,
         destinationId,
         name,
         category,
         description,
         days,
         price,
         maxGuests,
         itinerary,
         accommodation,
         transport,
         meals,
         difficulty,
         bestSeason,
         inclusions,
         exclusions)
 ;}
 @Override
 public BigDecimal calculatePrice(){
  return getBasePrice().multiply(new BigDecimal("1.05"));}
}
