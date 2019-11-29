package com.game.maze.persist.repository;

import com.game.maze.persist.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query(value = "SELECT count(*) FROM item",
            nativeQuery = true)
    Long findNumberOfItems();
}
