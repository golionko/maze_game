package com.game.maze.persist.repository;

import com.game.maze.persist.entity.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    List<Avatar> findAllByRoomId(Long roomId);
}
