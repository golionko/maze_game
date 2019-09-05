package com.game.maze.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

    @RequestMapping(value = "/admin/items", method = RequestMethod.GET)
    public String itemManagement(Model model){
        return "admin_items";
    }

}
