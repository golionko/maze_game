package com.game.maze.controller;

import com.game.maze.helper.LevelUpHelper;
import com.game.maze.model.Direction;
import com.game.maze.persist.entity.Avatar;
import com.game.maze.persist.repository.AvatarRepository;
import com.game.maze.persist.repository.LabyrinthRoomRepository;
import com.game.maze.service.AvatarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class AvatarController {

    private final AvatarService avatarService;
    private final AvatarRepository avatarRepository;
    private final LabyrinthRoomRepository labyrinthRoomRepository;

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

    @RequestMapping(value = "/avatar", method = RequestMethod.POST)
    public String createAvatar(Model model, @RequestBody Avatar avatar){
        avatarRepository.save(avatar);
        model.addAttribute("roomView", avatarService.getRoomViewForRoomAndAvatar(labyrinthRoomRepository.getOne(avatar.getRoomId()),avatar));
        return "room_view";
    }

    @RequestMapping(value = "/avatar/{id}", method = RequestMethod.PUT)
    String updateAvatar(Model model, @RequestBody Avatar updatedAvatar, @PathVariable Long id) {

        Avatar avatar =  avatarRepository.findById(id)
                .map(a -> {
                    a.setName(updatedAvatar.getName());
                    a.setXp(updatedAvatar.getXp());
                    a.setLevel(LevelUpHelper.calculateLevel(updatedAvatar.getXp().longValue()));
                    a.setStrength(updatedAvatar.getStrength());
                    a.setDexterity(updatedAvatar.getDexterity());
                    a.setLuck(updatedAvatar.getLuck());
                    a.setConstitution(updatedAvatar.getConstitution());
                    a.setHp(updatedAvatar.getHp());
                    a.setEnergy(updatedAvatar.getEnergy());
                    a.setRoomId(updatedAvatar.getRoomId());
                    return avatarRepository.save(a);
                })
                .orElseThrow(() -> new RuntimeException("Avatar to update could not be found"));
        model.addAttribute("roomView", avatarService.getRoomViewForRoomAndAvatar(labyrinthRoomRepository.getOne(avatar.getRoomId()),avatar));
        return "room_view";
    }

}
