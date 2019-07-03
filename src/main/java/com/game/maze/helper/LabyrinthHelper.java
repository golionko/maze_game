package com.game.maze.helper;

import com.game.maze.model.Direction;
import com.game.maze.model.LabyrinthRoomColor;
import com.game.maze.persist.entity.Labyrinth;
import com.game.maze.persist.entity.LabyrinthRoom;
import lombok.Data;

@Data
public class LabyrinthHelper {

    private Labyrinth labyrinth;
    private LabyrinthRoom[][][] cube;
    private int xBlank;
    private int yBlank;
    private int zBlank;

    public LabyrinthHelper(Labyrinth labyrinth){
        this.labyrinth = labyrinth;
        int size = labyrinth.getSize().intValue();
        cube = new LabyrinthRoom[size][size][size];
        for(LabyrinthRoom labyrinthRoom: labyrinth.getRooms()){
            if(LabyrinthRoomColor.BLANK.equals(labyrinthRoom.getRoomColor())){
                xBlank = labyrinthRoom.getXLocation().intValue();
                yBlank = labyrinthRoom.getYLocation().intValue();
                zBlank = labyrinthRoom.getZLocation().intValue();
            }
            cube[labyrinthRoom.getXLocation().intValue()][labyrinthRoom.getYLocation().intValue()][labyrinthRoom.getZLocation().intValue()] = labyrinthRoom;
        }
    }

    public LabyrinthRoom getRoomByLocation(int x, int y, int z){
        return cube[x][y][z];
    }

    public void shuffleLabyrinth(){
       labyrinth.getRooms().forEach(r -> moveBlankRoom(Direction.getRandom()));
    }

    public void moveBlankRoom(Direction direction){
        //if direction leads out of the cube we dont move
        switch (direction){
            case UP:
                if(yBlank + 1 == labyrinth.getSize().intValue()) return;
                swapWithBlankRoom(cube[xBlank][yBlank + 1][zBlank]);
                break;
            case DOWN:
                if(yBlank == 0) return;
                swapWithBlankRoom(cube[xBlank][yBlank - 1][zBlank]);
                break;
            case NORTH:
                if(zBlank == 0) return;
                swapWithBlankRoom(cube[xBlank][yBlank][zBlank - 1]);
                break;
            case SOUTH:
                if(zBlank + 1 == labyrinth.getSize().intValue()) return;
                swapWithBlankRoom(cube[xBlank][yBlank][zBlank + 1]);
                break;
            case WEST:
                if(xBlank == 0) return;
                swapWithBlankRoom(cube[xBlank - 1][yBlank][zBlank]);
                break;
            case EAST:
                if(xBlank + 1 == labyrinth.getSize().intValue()) return;
                swapWithBlankRoom(cube[xBlank + 1][yBlank][zBlank]);
                break;
        }
    }

    private void swapWithBlankRoom(LabyrinthRoom labyrinthRoom){
        int xNew = labyrinthRoom.getXLocation().intValue();
        int yNew = labyrinthRoom.getYLocation().intValue();
        int zNew = labyrinthRoom.getZLocation().intValue();
        labyrinthRoom.setXLocation(new Long(xBlank));
        labyrinthRoom.setYLocation(new Long(yBlank));
        labyrinthRoom.setZLocation(new Long(zBlank));
        cube[xNew][yNew][zNew] = cube[xBlank][yBlank][zBlank];
        cube[xBlank][yBlank][zBlank] = labyrinthRoom;
        cube[xNew][yNew][zNew].setXLocation(new Long(xNew));
        cube[xNew][yNew][zNew].setYLocation(new Long(yNew));
        cube[xNew][yNew][zNew].setZLocation(new Long(zNew));
        xBlank = xNew;
        yBlank = yNew;
        zBlank = zNew;
    }


}
