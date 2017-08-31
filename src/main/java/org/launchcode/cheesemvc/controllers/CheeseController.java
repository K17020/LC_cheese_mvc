package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.launchcode.cheesemvc.models.CheeseType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        model.addAttribute(new Cheese()); // We are passing a skeleton object into the add view
        model.addAttribute("cheeseTypes", CheeseType.values()); // Return an array of cheese types form the enum class
        return "cheese/add";
    }

    // Adds new cheese to the data class
    @RequestMapping(value = "add", method = RequestMethod.POST)
    // This is using the cheese class to manage the post request, by matching up the name in the HTML
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese, Errors errors, Model model) {
        //@Valid is specified in the Cheese class
        // Error is made available if there is an error and is made when there is an error

        //Bool value
        if(errors.hasErrors()){
            model.addAttribute("title","Add Cheese");
            return "cheese/add"; // return to the same page if the user gets it wrong
        }

        /* Whats going on?
        * Cheese newCheese = new Cheese
        * newCheese.setName(RequestParam("name"))
        * The request param is looking for a matching name in the class to assign itself to
        *

         */
        CheeseData.add(newCheese);
        return "redirect:";
    }

    // Displays the cheese from the object that you can remove
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "Remove Cheese");
        return "cheese/remove";
    }

    // Removes cheese based off the value of the cheese
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds) {

        for (int cheeseId : cheeseIds) {
            CheeseData.remove(cheeseId);
        }

        return "redirect:";
    }

}
