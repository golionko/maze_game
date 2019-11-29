package com.game.maze.controller;

import com.game.maze.helper.LevelUpHelper;
import com.game.maze.model.Direction;
import com.game.maze.model.view.RoomView;
import com.game.maze.persist.entity.Avatar;
import com.game.maze.persist.repository.AvatarRepository;
import com.game.maze.persist.repository.LabyrinthRoomRepository;
import com.game.maze.service.AvatarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AvatarController {

    private final AvatarService avatarService;
    private final AvatarRepository avatarRepository;
    private final LabyrinthRoomRepository labyrinthRoomRepository;

    @RequestMapping(value = "/avatar/{id}/move/{direction}", method = RequestMethod.POST)
    public RoomView init(@PathVariable(name = "id") Long id , @PathVariable(name = "direction") Direction direction){
        avatarService.moveAvatar(id,direction);
        Avatar avatar = avatarRepository.getOne(id);
        return avatarService.getRoomViewForRoomAndAvatar(labyrinthRoomRepository.getOne(avatar.getRoomId()),avatar);
    }

    @RequestMapping(value = "/avatar/{id}", method = RequestMethod.GET)
    public Avatar getAvatar(@PathVariable(name = "id") Long id){
        return avatarRepository.getOne(id);
    }

    @RequestMapping(value = "/avatar", method = RequestMethod.POST)
    public RoomView createAvatar(@RequestBody Avatar avatar){
        avatarRepository.save(avatar);
        return avatarService.getRoomViewForRoomAndAvatar(labyrinthRoomRepository.getOne(avatar.getRoomId()),avatar);
    }

    @RequestMapping(value = "/avatar/{id}", method = RequestMethod.PUT)
    public RoomView updateAvatar(@RequestBody Avatar updatedAvatar, @PathVariable Long id) {

        Avatar avatar =  avatarRepository.findById(id)
                .map(a -> {
                    a.setName(updatedAvatar.getName());
                    a.setXp(updatedAvatar.getXp());
                    a.setLevel(LevelUpHelper.calculateLevel(updatedAvatar.getXp()));
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
        return avatarService.getRoomViewForRoomAndAvatar(labyrinthRoomRepository.getOne(avatar.getRoomId()),avatar);
    }

}
