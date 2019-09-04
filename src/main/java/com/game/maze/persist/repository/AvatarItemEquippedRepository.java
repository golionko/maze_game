package com.game.maze.persist.repository;

import com.game.maze.persist.entity.AvatarItemEquipped;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvatarItemEquippedRepository extends JpaRepository<AvatarItemEquipped, Long> {
    List<AvatarItemEquipped> findByAvatarId(Long avatarId);
}
