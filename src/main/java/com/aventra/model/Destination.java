package com.aventra.model;

public class Destination {
    private int destinationId;
    private String name;
    private String location;
    private String description;
    private String difficulty;

    public Destination(int id, String name, String location, String description, String difficulty) {
        this.destinationId=id; this.name=name; this.location=location;
        this.description=description; this.difficulty=difficulty;
    }
    public int getDestinationId(){return destinationId;}
    public void setDestinationId(int id){this.destinationId=id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public String getLocation(){return location;}
    public void setLocation(String location){this.location=location;}
    public String getDescription(){return description;}
    public void setDescription(String description){this.description=description;}
    public String getDifficulty(){return difficulty;}
    public void setDifficulty(String difficulty){this.difficulty=difficulty;}
    @Override public String toString(){return name+" — "+location;}
}
