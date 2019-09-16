package com.game.maze.schedule;

import com.game.maze.model.Direction;
import com.game.maze.persist.entity.Creature;
import com.game.maze.persist.entity.LabyrinthRoom;
import com.game.maze.persist.entity.LabyrinthRoomCreature;
import com.game.maze.persist.repository.CreatureRepository;
import com.game.maze.persist.repository.LabyrinthRoomCreatureRepository;
import com.game.maze.persist.repository.LabyrinthRoomRepository;
import com.game.maze.service.CreatureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@Slf4j
@RequiredArgsConstructor
public class PopulateMonstersTasks {

    private final CreatureRepository creatureRepository;
    private final LabyrinthRoomCreatureRepository roomCreatureRepository;
    private final LabyrinthRoomRepository labyrinthRoomRepository;
    private final CreatureService creatureService;
    private Random rand = new Random();
    private final Long MAX_LEVEL = 5L;

    @Scheduled(fixedRate = 50000)
    public void addMonsterToLabyrinth() {

        List<Creature> creaturesList = creatureRepository.findAllByLevelBefore(MAX_LEVEL);
        List<LabyrinthRoom> rooms = labyrinthRoomRepository.findAll();
        if(creaturesList != null && rooms != null){
            Creature randomCreature = creaturesList.get(rand.nextInt(creaturesList.size()));
            LabyrinthRoom randomRoom = rooms.get(rand.nextInt(rooms.size()));
            roomCreatureRepository.save(new LabyrinthRoomCreature(randomCreature, randomRoom.getId()));
            log.info("Added {} (id:{}) to room {}", randomCreature.getName() , randomCreature.getId() , randomRoom.getId());
        }
    }

    @Scheduled(fixedRate = 50000)
    public void moveRandomMonster() {
        LabyrinthRoomCreature roomCreature = roomCreatureRepository.getRandomLabyrinthRoomCreature();
        creatureService.moveCreature(roomCreature, Direction.getRandom());
    }
}
