package com.game.maze.model.view;

import com.game.maze.persist.entity.Avatar;
import com.game.maze.persist.entity.LabyrinthRoom;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class RoomView {
    private Long avatarId;
    private LabyrinthRoom room;
    Map<String,LabyrinthRoom> surroundingRooms;
    List<Avatar> avatars;
}
