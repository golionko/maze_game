package com.game.maze.controller;

import com.game.maze.model.Direction;
import com.game.maze.persist.entity.Avatar;
import com.game.maze.persist.repository.AvatarRepository;
import com.game.maze.persist.repository.LabyrinthRoomRepository;
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
    @Autowired
    AvatarRepository avatarRepository;
    @Autowired
    LabyrinthRoomRepository labyrinthRoomRepository;

    @RequestMapping(value = "/avatar/{id}/move/{direction}", method = RequestMethod.POST)
    public String init(Model model, @PathVariable(name = "id") Long id , @PathVariable(name = "direction") Direction direction){
        avatarService.moveAvatar(id,direction);
        Avatar avatar = avatarRepository.getOne(id);
        model.addAttribute("roomView", avatarService.getRoomViewForRoomAndAvatar(labyrinthRoomRepository.getOne(avatar.getRoomId()),avatar));
        return "room_view";
    }

    @RequestMapping(value = "/avatar/{id}", method = RequestMethod.GET)
    public String init(Model model, @PathVariable(name = "id") Long id){
        Avatar avatar = avatarRepository.getOne(id);
        model.addAttribute("roomView", avatarService.getRoomViewForRoomAndAvatar(labyrinthRoomRepository.getOne(avatar.getRoomId()),avatar));
        return "room_view";
    }
}
