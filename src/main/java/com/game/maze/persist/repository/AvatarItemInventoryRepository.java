package com.game.maze.persist.repository;

import com.game.maze.persist.entity.AvatarItemInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvatarItemInventoryRepository extends JpaRepository<AvatarItemInventory, Long> {

    AvatarItemInventory findByAvatarIdAndItemId(Long avatarId, Long ItemId);
    List<AvatarItemInventory> findByAvatarId(Long avatarId);
}
