package com.aventra.model;
import java.math.BigDecimal;
public abstract class TourismPackage {
 private int packageId,destinationId,durationDays,maxGuests; private String name,category,description,itinerary,accommodation,transport,meals,difficulty,bestSeason,inclusions,exclusions; private BigDecimal basePrice;
 protected TourismPackage(int id,int destinationId,String name,String category,String description,int days,BigDecimal price,int maxGuests,String itinerary,String accommodation,String transport,String meals,String difficulty,String bestSeason,String inclusions,String exclusions){
  this.packageId=id;this.destinationId=destinationId;this.name=name;this.category=category;this.description=description;this.durationDays=days;this.basePrice=price;this.maxGuests=maxGuests;this.itinerary=itinerary;this.accommodation=accommodation;this.transport=transport;this.meals=meals;this.difficulty=difficulty;this.bestSeason=bestSeason;this.inclusions=inclusions;this.exclusions=exclusions;
 }
 public abstract BigDecimal calculatePrice(); public int getPackageId(){
  return packageId;} public int getDestinationId(){return destinationId;
 }
 public String getName(){return name;} public String getCategory(){
  return category;} public String getDescription(){return description;
 }

 public int getDurationDays(){
  return durationDays;
 }

 public BigDecimal getBasePrice(){
  return basePrice;}
 public int getMaxGuests(){
  return maxGuests;}
 public String getItinerary(){
  return itinerary;
 }
 public String getAccommodation(){
  return accommodation;
 } public String getTransport(){
  return transport;
 }
 public String getMeals(){
  return meals;
 }
 public String getDifficulty(){
  return difficulty;
 }
 public String getBestSeason(){
  return bestSeason;
 }
 public String getInclusions(){
  return inclusions;
 }
 public String getExclusions(){
  return exclusions;
 }
 public void setName(String n){
  name=n;
 }
 public void setDescription(String d){
  description=d;
 }
 public void setBasePrice(BigDecimal p){
  basePrice=p;
 }
 @Override
 public String toString(){
  return name+" ("+durationDays+" days) - LKR "+calculatePrice();
 }
}
