package org.launchcode.cheesemvc.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // Maps the class to the database
public class Category {
    // Fields

    // This is the key in the database and it will auto increment
    @Id
    @GeneratedValue
    private int id;

    // Basic Validation
    @NotNull
    @Size(min = 3,max = 15)
    private String name;

    // Constructors


    public Category(String name) {
        this.name = name;
    }

    // Constructor required for Spring Boot
    // This is the default constructor
    public Category() { }

    // Setters and Getters
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
