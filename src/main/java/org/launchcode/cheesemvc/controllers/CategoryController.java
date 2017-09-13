package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.data.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("category")
public class CategoryController {

    // This will create an instance of the is class
    @Autowired
    private CategoryDao categoryDao;


    // Index handler
    @RequestMapping(value = "")
    public String index(Model model) {
    model.addAttribute("categories",categoryDao.findAll());
    model.addAttribute("title","Categories Works");
        return "category/index";
    }
}
