package org.launchcode.cheesemvc.models;

// enum is a type of class, stands for enumeration
public enum CheeseType {

    HARD ("Hard"),
    SOFT ("Soft"),
    FAKE ("Fake");

    // The values in a enum class need to all be in uppercase

    private final String name; // Once these objects are created they should not change hence the final

    // Constructor
    CheeseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}