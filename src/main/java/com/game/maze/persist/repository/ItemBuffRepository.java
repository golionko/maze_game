package com.game.maze.persist.repository;

import com.game.maze.persist.entity.ItemBuff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemBuffRepository extends JpaRepository<ItemBuff, Long> {
}
