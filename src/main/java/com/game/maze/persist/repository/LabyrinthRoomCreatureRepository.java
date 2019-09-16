package com.game.maze.persist.repository;

import com.game.maze.persist.entity.LabyrinthRoomCreature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LabyrinthRoomCreatureRepository extends JpaRepository<LabyrinthRoomCreature, Long> {

    List<LabyrinthRoomCreature> findAllByRoomId(Long roomId);
    List<LabyrinthRoomCreature> getLabyrinthRoomCreaturesByCreatureId(Long id);

    @Query(value = "SELECT * FROM labyrinth_room_creature ORDER BY RAND() LIMIT 1", nativeQuery = true)
    LabyrinthRoomCreature getRandomLabyrinthRoomCreature();
}
