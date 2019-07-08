package com.game.maze.controller;

import com.game.maze.persist.entity.Avatar;
import com.game.maze.persist.repository.AvatarRepository;
import com.game.maze.persist.repository.LabyrinthRoomRepository;
import com.game.maze.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @Autowired
    AvatarService avatarService;
    @Autowired
    LabyrinthRoomRepository labyrinthRoomRepository;
    @Autowired
    AvatarRepository avatarRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String init(Model model){
        Avatar avatar = avatarRepository.getOne(1L);


        model.addAttribute("roomView",avatarService.getRoomViewForRoomAndAvatar(labyrinthRoomRepository.getOne(avatar.getRoomId()),avatar));
        return "index";
    }
}
