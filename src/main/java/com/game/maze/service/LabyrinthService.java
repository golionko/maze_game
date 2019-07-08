package com.game.maze.service;

import com.game.maze.helper.LabyrinthHelper;
import com.game.maze.model.Direction;
import com.game.maze.model.LabyrinthRoomColor;
import com.game.maze.persist.entity.Labyrinth;
import com.game.maze.persist.entity.LabyrinthRoom;
import com.game.maze.persist.repository.LabyrinthRepository;
import com.game.maze.persist.repository.LabyrinthRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class LabyrinthService {

    @Autowired
    LabyrinthRepository labyrinthRepository;
    @Autowired
    LabyrinthRoomRepository labyrinthRoomRepository;

    @Transactional
    public Labyrinth createLabyrinth(long size) {
        Labyrinth labyrinth = new Labyrinth("First Dimension");
        labyrinth.setSize(size);
        labyrinthRepository.save(labyrinth);
        List<LabyrinthRoom> rooms = new ArrayList<>();
        for (long i = 0 ; i < size ; i++) {
            for (long j = 0 ; j < size ; j++) {
                for (long k = 0 ; k < size ; k++) {
                    if(i==0 && j==0 && k==0){
                        rooms.add(new LabyrinthRoom(labyrinth.getId(), LabyrinthRoomColor.BLANK, i, j, k));
                    } else {
                        rooms.add(new LabyrinthRoom(labyrinth.getId(), LabyrinthRoomColor.getRandom(), i, j, k));
                    }
                }
            }
        }
        labyrinth.setRooms(rooms);
        labyrinthRepository.save(labyrinth);

        return labyrinthRepository.findById(labyrinth.getId()).get();
    }

    @Transactional
    public Labyrinth shuffleLabyrinthRooms(Long labyrinthId){
        Labyrinth labyrinth = labyrinthRepository.getOne(labyrinthId);
        LabyrinthHelper labyrinthHelper = new LabyrinthHelper(labyrinth);
        labyrinthHelper.shuffleLabyrinth();
        return labyrinthRepository.save(labyrinth);
    }

    public LabyrinthRoom getLabyrinthRoomByLocation(long x, long y, long z){
        return labyrinthRoomRepository.findByXLocationAndYLocationAndZLocation(x, y, z);
    }

    public LabyrinthRoom getLabyrinthRoomByOrigin(long x, long y, long z){
        return labyrinthRoomRepository.findByXOriginAndYOriginAndZOrigin(x, y, z);
    }

    public LabyrinthRoom getRoomInDirection(LabyrinthRoom room, Direction direction){
        Long size = labyrinthRepository.findSizeById(room.getLabyrinthId());
        switch(direction){
            case UP:
                if(room.getYLocation() + 1 < size){
                    return getLabyrinthRoomByLocation(room.getXLocation(),room.getYLocation() + 1,room.getZLocation());
                }
            case DOWN:
                if(room.getYLocation() - 1 > 0){
                    return getLabyrinthRoomByLocation(room.getXLocation(),room.getYLocation() - 1,room.getZLocation());
                }
            case WEST:
                if(room.getXLocation() - 1 > 0){
                    return getLabyrinthRoomByLocation(room.getXLocation() - 1,room.getYLocation(),room.getZLocation());
                }
            case EAST:
                if(room.getXLocation() + 1 < size){
                    return getLabyrinthRoomByLocation(room.getXLocation() + 1,room.getYLocation(),room.getZLocation());
                }
            case NORTH:
                if(room.getZLocation() - 1 > 0){
                    return getLabyrinthRoomByLocation(room.getXLocation(),room.getYLocation(),room.getZLocation() - 1);
                }
            case SOUTH:
                if(room.getZLocation() + 1 < size){
                    return getLabyrinthRoomByLocation(room.getXLocation(),room.getYLocation(),room.getZLocation() + 1);
                }
        }
        return null;
    }

}
