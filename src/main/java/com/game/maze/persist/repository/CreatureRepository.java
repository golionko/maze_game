package com.game.maze.persist.repository;

import com.game.maze.persist.entity.Creature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CreatureRepository extends JpaRepository<Creature, Long> {
    List<Creature> findAllByLevelBefore(Long level);

    @Query(value = "SELECT count(*) FROM creature",
            nativeQuery = true)
    Long findNumberOfCreatures();
}
