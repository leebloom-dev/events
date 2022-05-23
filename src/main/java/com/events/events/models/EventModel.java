package com.events.events.models;

public class EventModel {

    private int id;
    private String name;
    
    // Static: belong to the type itself rather than the instance of that type.
    // Only one of these to share across all instances of the class.
    private static int nextId = 1;

    public EventModel() {

    }

    public EventModel(String name) {
        this.id = nextId;
        this.name = name;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
