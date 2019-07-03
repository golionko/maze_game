package com.game.maze.service;

import com.game.maze.helper.LabyrinthHelper;
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
    public Labyrinth createLabyrinth(int size) {
        Labyrinth labyrinth = new Labyrinth("First Dimension");
        labyrinth.setSize(new Long(size));
        labyrinthRepository.save(labyrinth);
        List<LabyrinthRoom> rooms = new ArrayList<>();
        for (int i = 0 ; i < size ; i++) {
            for (int j = 0 ; j < size ; j++) {
                for (int k = 0 ; k < size ; k++) {
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

    public LabyrinthRoom getLabyrinthRoomByLocation(int x, int y, int z){
        return labyrinthRoomRepository.findByXLocationAndYLocationAndZLocation(new Long(x), new Long(y), new Long((z)));
    }

    public LabyrinthRoom getLabyrinthRoomByOrigin(int x, int y, int z){
        return labyrinthRoomRepository.findByXOriginAndYOriginAndZOrigin(new Long(x), new Long(y), new Long((z)));
    }



}
