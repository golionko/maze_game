package com.game.maze.model;

import lombok.Data;

@Data
public class MazeStats {
    private Long rooms;
    private Long players;
    private Long monsters;
    private Long items;
}
