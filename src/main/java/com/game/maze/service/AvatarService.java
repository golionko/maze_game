package com.game.maze.service;

import com.game.maze.model.Direction;
import com.game.maze.model.view.RoomView;
import com.game.maze.persist.entity.Avatar;
import com.game.maze.persist.entity.LabyrinthRoom;
import com.game.maze.persist.entity.LabyrinthRoomCreature;
import com.game.maze.persist.repository.AvatarRepository;
import com.game.maze.persist.repository.LabyrinthRoomCreatureRepository;
import com.game.maze.persist.repository.LabyrinthRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AvatarService {

    private final AvatarRepository avatarRepository;
    private final LabyrinthService labyrinthService;
    private final LabyrinthRoomRepository labyrinthRoomRepository;
    private final LabyrinthRoomCreatureRepository labyrinthRoomCreatureRepository;

    private final static long MOVEMENT_COST = 5;

    public void moveAvatar(Long avatarId, Direction direction){
        Avatar avatar = avatarRepository.getOne(avatarId);
        LabyrinthRoom room = labyrinthRoomRepository.getOne(avatar.getRoomId());
        if(avatar.getHp() > 0 && avatar.getMaxEnergy() - avatar.getEnergy() >= MOVEMENT_COST) {
            LabyrinthRoom newRoom = labyrinthService.getRoomInDirection(room, direction);
            if (newRoom != null) {
                avatar.setRoomId(newRoom.getId());
                avatar.setEnergy(avatar.getEnergy() - MOVEMENT_COST);
                avatarRepository.save(avatar);
            }
        }
    }

    public RoomView getRoomViewForRoomAndAvatar(LabyrinthRoom room, Avatar avatar){
        RoomView roomView = new RoomView();
        roomView.setAvatar(avatar);
        roomView.setRoom(room);
        Map<String,LabyrinthRoom> surroundingRooms = new HashMap<>();
        for(Direction direction: Direction.values()){
            surroundingRooms.put(direction.toString(),labyrinthService.getRoomInDirection(room,direction));
        }
        roomView.setSurroundingRooms(surroundingRooms);
        roomView.setAvatars(avatarRepository.findAllByRoomId(room.getId()));
        List<LabyrinthRoomCreature> creaturesInRoomList = labyrinthRoomCreatureRepository.findAllByRoomId(room.getId());
        roomView.setCreatures(creaturesInRoomList.stream().map(LabyrinthRoomCreature::getCreature).collect(Collectors.toList()));
        return roomView;
    }
}
