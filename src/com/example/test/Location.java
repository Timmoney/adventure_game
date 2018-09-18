package com.example.test;
import java.util.HashMap;
import java.util.Map;

/*
* immutability --> constructor does not initiate directly from its private member
*                  instead create a new object
* notes --> need to carefully check the passing argument, might happened to be a
*           null pointer
* */

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        //initialized the exit map
        //this.exits = new HashMap<String, Integer>();

        if(exits!=null){
            //problem here is that if exist is passing a null, there will be a null pointer exception
            this.exits = new HashMap<String, Integer>(exits);
        }
        else{
            this.exits = new HashMap<String, Integer>();
        }
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        //making a new copy of exits
        //creating a new object, will not affect the original exits
        return new HashMap<String, Integer>(exits);
    }

//    public void addExit(String direction, int location){
//        exits.put(direction, location);
//    }
}
