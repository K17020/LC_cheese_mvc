package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// Changes the request map to /cheese
@RequestMapping("cheese")
public class CheeseController {

    @RequestMapping(value = "")
    public String index(){
        return "cheese/index";
    }
}
