package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
// Changes the request map to /cheese
@RequestMapping("cheese")
public class CheeseController {

    // request location is at the root
    @RequestMapping(value = "")
    public String index(Model model){

        /** Location for the page template
         * model attribute works like a key value pare
         * we are using time leaf template engine
        */
        // Holds the names of the cheeses
        ArrayList<String> cheeses = new ArrayList<>();
        cheeses.add("Chedder");
        cheeses.add("Swiss");
        cheeses.add("Munster");

        model.addAttribute("cheeses", cheeses); // pass the array list to the view
        model.addAttribute("title","My Cheeses"); // passes data into the view
        return "cheese/index";
    }
}
