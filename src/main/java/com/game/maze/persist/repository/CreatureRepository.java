package com.game.maze.persist.repository;

import com.game.maze.persist.entity.Creature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreatureRepository extends JpaRepository<Creature, Long> {


}
