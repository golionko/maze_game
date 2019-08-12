package com.game.maze.model.view;

import com.game.maze.persist.entity.Avatar;
import lombok.Data;

import java.util.List;

@Data
public class UserView {
    Long id;
    String name;
    List<Avatar> avatars;
}
