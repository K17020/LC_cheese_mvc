package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
// Changes the request map to /cheese
@RequestMapping("cheese")
public class CheeseController {


    static ArrayList<Cheese> cheeses = new ArrayList<>();


    // request location is at the root
    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("cheeses", cheeses); // pass the array list to the view
        model.addAttribute("title","My Cheeses"); // passes data into the view
        return "cheese/index";
    }

    // Form that get request
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAndCheeseForm(Model model){
        model.addAttribute("title","Add Cheese");
        return "cheese/add";
    }

    // Post request for the form
    @RequestMapping(value = "add", method = RequestMethod.POST)
    // Handle going to pass param named cheeseName
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDesc){
        Cheese newCheese = new Cheese(cheeseName,cheeseDesc);
        cheeses.add(newCheese);
        // redirect /cheese at the root
        return "redirect:";
    }

    // Displays page of the cheeses you can remove
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model){
        model.addAttribute("cheeses", cheeses); // pass the array list to the view
        model.addAttribute("title","Remove Cheese"); // passes data into the view
        return "cheese/remove";
    }
    //removes cheeses from an array
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String removeCheeseForm(@RequestParam String[] cheeseRemove){
        for (String cheese:cheeseRemove){
            cheeses.remove(cheese);

        }
        return "redirect:";
    }

}
