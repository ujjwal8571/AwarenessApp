package com.example.android.awarenessapp;

/**
 * Created by ujjwal on 6/5/17.
 */

public class Complaint {

//    Integer id;
    String name;
    String description;
    Boolean isResolved;
    String location;

    public Complaint(String name,String description,String location){
//        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.isResolved = false;
    }

    public Complaint(){

    }

//    public int getID(){
//        return this.id;
//    }

    public String getName(){
        return this.name;

    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public boolean getSsResolved(){
        return this.isResolved;
    }

    public void setIsResolved(Boolean val){
        this.isResolved = val;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getLocation(){
        return this.location;
    }

}
