package com.game.maze.persist.repository;

import com.game.maze.persist.entity.LabyrinthRoomCreature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabyrinthRoomCreatureRepository extends JpaRepository<LabyrinthRoomCreature, Long> {
}
