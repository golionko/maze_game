package com.game.maze.service;

import com.game.maze.model.Direction;
import com.game.maze.persist.entity.LabyrinthRoom;
import com.game.maze.persist.entity.LabyrinthRoomCreature;
import com.game.maze.persist.repository.LabyrinthRoomCreatureRepository;
import com.game.maze.persist.repository.LabyrinthRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreatureService {

    private final LabyrinthRoomCreatureRepository roomCreatureRepository;
    private final LabyrinthService labyrinthService;
    private final LabyrinthRoomRepository labyrinthRoomRepository;

    @Transactional
    public void moveCreature(LabyrinthRoomCreature roomCreature, Direction direction){
        LabyrinthRoom room = labyrinthRoomRepository.getOne(roomCreature.getRoomId());
        LabyrinthRoom newRoom = labyrinthService.getRoomInDirection(room, direction);
        if (newRoom != null) {
            Long oldRoomId = roomCreature.getRoomId();
            roomCreature.setRoomId(newRoom.getId());
            roomCreatureRepository.save(roomCreature);
            log.info("Moved {} (id:{}) from room {} to room {}",
                    roomCreature.getCreature().getName() , roomCreature.getCreature().getId(), oldRoomId , newRoom.getId());
        }
    }
}
