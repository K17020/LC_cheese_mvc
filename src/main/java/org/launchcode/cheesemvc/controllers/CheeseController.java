package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheeseController {

    @RequestMapping(value = "")
    public String index(){
        return "index";
    }
}
