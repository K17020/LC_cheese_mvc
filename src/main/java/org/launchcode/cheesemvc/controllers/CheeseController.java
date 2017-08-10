package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// Changes the request map to /cheese
@RequestMapping("cheese")
public class CheeseController {

    // request location is at the root
    @RequestMapping(value = "")
    public String index(){
        // Location for the page template
        return "cheese/index";
    }
}
