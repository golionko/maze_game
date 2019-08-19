package com.game.maze.controller;

import com.game.maze.persist.entity.Avatar;
import com.game.maze.persist.entity.AvatarItemInventory;
import com.game.maze.persist.repository.AvatarItemInventoryRepository;
import com.game.maze.persist.repository.AvatarRepository;
import com.game.maze.persist.repository.LabyrinthRoomRepository;
import com.game.maze.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AvatarItemController {

    @Autowired
    AvatarItemInventoryRepository avatarItemInventoryRepository;
    @Autowired
    AvatarService avatarService;
    @Autowired
    LabyrinthRoomRepository labyrinthRoomRepository;
    @Autowired
    AvatarRepository avatarRepository;

    @RequestMapping(value = "/avatar/{id}/item/{itemId}", method = RequestMethod.POST)
    public String addItemToAvatar(Model model,
                       @PathVariable(name = "id") Long id,
                       @PathVariable(name = "itemId") Long itemId,
                       @RequestParam(name="amount") Long amount){
        AvatarItemInventory avatarItemInventory = new AvatarItemInventory();
        avatarItemInventory.setAvatarId(id);
        avatarItemInventory.setItemId(itemId);
        avatarItemInventory.setAmount(amount);
        return saveAndReturnRoomView(model, id, avatarItemInventory);
    }

    @RequestMapping(value = "/avatar/{id}/item/{itemId}", method = RequestMethod.PUT)
    public String updateAvatarItem(Model model,
                                  @PathVariable(name = "id") Long id,
                                  @PathVariable(name = "itemId") Long itemId,
                                  @RequestParam(name="amount") Long amount){
        AvatarItemInventory avatarItemInventory = avatarItemInventoryRepository.findByAvatarIdAndItemId(id, itemId);
        avatarItemInventory.setAmount(amount);
        return saveAndReturnRoomView(model, id, avatarItemInventory);
    }

    @RequestMapping(value = "/avatar/{id}/item/{itemId}", method = RequestMethod.DELETE)
    public String deleteItemFromAvatar(Model model,
                                   @PathVariable(name = "id") Long id,
                                   @PathVariable(name = "itemId") Long itemId,
                                   @RequestParam(name="amount") Long amount){
        AvatarItemInventory avatarItemInventory = avatarItemInventoryRepository.findByAvatarIdAndItemId(id, itemId);
        if(avatarItemInventory.getAmount() > amount){
            avatarItemInventory.setAmount(avatarItemInventory.getAmount() - amount);
        } else {
            avatarItemInventory.setAmount(0L);
        }
        return saveAndReturnRoomView(model, id, avatarItemInventory);
    }

    private String saveAndReturnRoomView(Model model, Long id, AvatarItemInventory avatarItemInventory) {
        avatarItemInventoryRepository.save(avatarItemInventory);
        Avatar avatar = avatarRepository.getOne(id);
        model.addAttribute("roomView", avatarService.getRoomViewForRoomAndAvatar(labyrinthRoomRepository.getOne(avatar.getRoomId()), avatar));
        return "room_view";
    }
}
