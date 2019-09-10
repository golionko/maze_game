package com.game.maze.persist.repository;

import com.game.maze.persist.entity.LabyrinthRoomCreature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LabyrinthRoomCreatureRepository extends JpaRepository<LabyrinthRoomCreature, Long> {

    List<LabyrinthRoomCreature> findAllByRoomId(Long roomId);
}
