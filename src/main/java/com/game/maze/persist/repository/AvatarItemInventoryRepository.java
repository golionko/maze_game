package com.game.maze.persist.repository;

import com.game.maze.persist.entity.AvatarItemInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvatarItemInventoryRepository extends JpaRepository<AvatarItemInventory, Long> {

    AvatarItemInventory findByAvatarIdAndItemId(Long avatarId, Long ItemId);
}
