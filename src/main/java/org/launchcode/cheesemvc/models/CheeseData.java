package org.launchcode.cheesemvc.models;

import java.util.ArrayList;

public class CheeseData {

    static ArrayList<Cheese> cheeses = new ArrayList<>();


    // Method to get all the cheeses
    public static ArrayList<Cheese> getAll(){
        return cheeses;
    }

    // Method to add cheeses
    public static void add(Cheese newCheese){
        cheeses.add(newCheese);
    }
    // Method to remove cheeses
    public static void remove(int id){
        Cheese cheeseToRemove = getById(id);
        cheeses.remove(cheeseToRemove);
    }

    // Get a cheese by a specific ID
    public static Cheese getById(int id){

        Cheese theCheese = null;

        // looping through the cheese to find it's id
        for (Cheese candidateCheese : cheeses){
            if (candidateCheese.getCheeseID() == id){
                theCheese = candidateCheese;
            }
        }

        return theCheese;
    }
}
