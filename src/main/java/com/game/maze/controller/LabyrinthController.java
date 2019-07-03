package com.game.maze.controller;

import com.game.maze.persist.entity.Labyrinth;
import com.game.maze.service.LabyrinthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LabyrinthController {

    @Autowired
    LabyrinthService labyrinthService;

    @RequestMapping(value = "/labyrinth/create", method = RequestMethod.GET)
    public String init(Model model){

        Labyrinth labyrinth = labyrinthService.createLabyrinth(10);
        model.addAttribute("labyrinth", labyrinth);
        model.addAttribute("action", "Created");
        return "labyrinth_action";
    }

    @RequestMapping(value = "/labyrinth/shuffle/{id}", method = RequestMethod.GET)
    public String init(Model model, @PathVariable(name = "id") Long id){
        model.addAttribute("labyrinth", labyrinthService.shuffleLabyrinthRooms(id));
        model.addAttribute("action", "Shuffled");
        return "labyrinth_action";
    }
}
