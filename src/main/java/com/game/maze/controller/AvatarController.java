package com.game.maze.controller;

import com.game.maze.model.Direction;
import com.game.maze.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AvatarController {

    @Autowired
    AvatarService avatarService;

    @RequestMapping(value = "/avatar/{id}/move/{direction}", method = RequestMethod.GET)
    public String init(Model model, @PathVariable(name = "id") Long id , @PathVariable(name = "direction") Direction direction){

        model.addAttribute("roomView", avatarService.moveAvatar(id,direction));
        return "index";
    }
}
