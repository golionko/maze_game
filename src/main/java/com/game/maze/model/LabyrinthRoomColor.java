package com.game.maze.model;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public enum  LabyrinthRoomColor {
    BLANK, RED, BLUE, YELLOW, BLACK, WHITE;

    public static LabyrinthRoomColor getRandom(){
        Random rand = new Random();
        LabyrinthRoomColor color =
                Arrays.stream(LabyrinthRoomColor.values())
                        .filter(labyrinthRoomColor -> !labyrinthRoomColor.equals(LabyrinthRoomColor.BLANK))
                        .collect(Collectors.toList())
                        .get(rand.nextInt( LabyrinthRoomColor.values().length - 1));
        return color;
    }
}
