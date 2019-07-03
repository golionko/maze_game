package com.game.maze.model;

import java.util.Random;

public enum Direction { //(0,0,0) is the north west bottom corner of the cube
    UP, DOWN, NORTH, SOUTH, WEST, EAST;

    public static Direction getRandom(){
        Random rand = new Random();
        return Direction.values()[rand.nextInt( Direction.values().length)];
    }
}
