package org.launchcode.cheesemvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserValidation {


    // Default mapping to the page
    @RequestMapping(value="")
    public String index(Model model){
        return "user/index";
    }

    @RequestMapping(value="add")
    public String Add(Model model){
        model.addAttribute("title","Add User");
        return "user/add";
    }

}
