package com.game.maze.persist.repository;

import com.game.maze.persist.entity.LabyrinthRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabyrinthRoomRepository  extends JpaRepository<LabyrinthRoom, Long> {

    LabyrinthRoom findByXLocationAndYLocationAndZLocation(Long xLocation, Long yLocation, Long zLocation);
    LabyrinthRoom findByXOriginAndYOriginAndZOrigin(Long xOrigin, Long yOrigin, Long zOrigin);
}
