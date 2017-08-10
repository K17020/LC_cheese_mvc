package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("title","My Cheeses");
        return "cheese/index";
    }
}
