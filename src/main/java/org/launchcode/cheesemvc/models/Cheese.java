package org.launchcode.cheesemvc.models;

public class Cheese {

    private String name;
    private String description;
    private int cheeseID; // A number to keep track of object
    private static int nextID = 1; // This field is shared across objects

    public Cheese(String name, String description) {
        this(); // Call the default constructor
        this.name = name;
        this.description = description;
    }

    // This is the default constructor
    public Cheese(){
        cheeseID = nextID; // Assign the first object the static value
        nextID++; // Adds 1 to each object that is created after
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public int getCheeseID() {
        return cheeseID;
    }

    public void setCheeseID(int cheeseID) {
        this.cheeseID = cheeseID;
    }

    public static int getNextID() {
        return nextID;
    }

    public static void setNextID(int nextID) {
        Cheese.nextID = nextID;
    }
}
