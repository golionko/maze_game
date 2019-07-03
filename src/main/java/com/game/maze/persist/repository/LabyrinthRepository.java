package com.game.maze.persist.repository;

import com.game.maze.persist.entity.Labyrinth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LabyrinthRepository extends JpaRepository<Labyrinth, Long> {
}
