package com.game.maze.controller;

import com.game.maze.service.LabyrinthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @Autowired
    LabyrinthService labyrinthService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String init(Model model){

        model.addAttribute("labyrinthRoom",labyrinthService.getLabyrinthRoomByLocation(1,2,3));
        return "index";
    }
}
