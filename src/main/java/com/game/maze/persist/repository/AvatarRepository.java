package com.game.maze.persist.repository;

import com.game.maze.persist.entity.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    List<Avatar> findAllByRoomId(Long roomId);
    List<Avatar> findAllByUserId(Long userId);

    @Query(value = "SELECT count(*) FROM avatar",
            nativeQuery = true)
    Long findNumberOfAvatars();
}
