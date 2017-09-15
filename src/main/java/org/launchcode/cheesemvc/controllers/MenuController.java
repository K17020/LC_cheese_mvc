package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Menu;
import org.launchcode.cheesemvc.models.data.CheeseDao;
import org.launchcode.cheesemvc.models.data.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;


@Controller()
@RequestMapping("menu")
public class MenuController {

    @Autowired
    CheeseDao cheeseDao;

    @Autowired
    MenuDao menuDao;

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("title","Menus");
        model.addAttribute("menus",menuDao.findAll());
        return "menu/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("title","Menus");
        model.addAttribute(new Menu());
        return "menu/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Menu menu, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Menu");
            return "menu/add";
        }
        menuDao.save(menu);
        return "redirect:view/" + menu.getId();
    }

    @RequestMapping(value="view/{menuId}", method = RequestMethod.GET)
    public String viewMenu(Model model, @pathVariable int menuId){

        Menu menu = menuDao.findOne(menuId);
        model.addAttribute("title", menu.getName());
        model.addAttribute("cheeses",menu.getCheeses());
        model.addAttribute("menuId",menu.getId());

        return "menu/view";
    }
}
