package com.game.maze.service;

import com.game.maze.model.Direction;
import com.game.maze.model.view.RoomView;
import com.game.maze.persist.entity.Avatar;
import com.game.maze.persist.entity.LabyrinthRoom;
import com.game.maze.persist.repository.AvatarRepository;
import com.game.maze.persist.repository.LabyrinthRepository;
import com.game.maze.persist.repository.LabyrinthRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AvatarService {

    @Autowired
    AvatarRepository avatarRepository;
    @Autowired
    LabyrinthService labyrinthService;
    @Autowired
    LabyrinthRoomRepository labyrinthRoomRepository;
    @Autowired
    LabyrinthRepository labyrinthRepository;

    public RoomView moveAvatar(Long avatarId, Direction direction){
        Avatar avatar = avatarRepository.getOne(avatarId);
        LabyrinthRoom room = labyrinthRoomRepository.getOne(avatar.getRoomId());
        LabyrinthRoom newRoom = labyrinthService.getRoomInDirection(room,direction);
        if(newRoom != null){
            avatar.setRoomId(newRoom.getId());
            avatarRepository.save(avatar);
            room = newRoom;
        }

        return getRoomViewForRoomAndAvatar(room,avatar);
    }

    public RoomView getRoomViewForRoomAndAvatar(LabyrinthRoom room, Avatar avatar){
        RoomView roomView = new RoomView();
        roomView.setAvatarId(avatar.getId());
        roomView.setRoom(room);
        Map<String,LabyrinthRoom> surroundingRooms = new HashMap<>();
        for(Direction direction: Direction.values()){
            surroundingRooms.put(direction.toString(),labyrinthService.getRoomInDirection(room,direction));
        }
        roomView.setSurroundingRooms(surroundingRooms);
        roomView.setAvatars(avatarRepository.findAllByRoomId(room.getId()));
        return roomView;
    }
}
