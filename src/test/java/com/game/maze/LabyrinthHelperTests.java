package com.game.maze;

import com.game.maze.helper.LabyrinthHelper;
import com.game.maze.model.Direction;
import com.game.maze.model.LabyrinthRoomColor;
import com.game.maze.persist.entity.Labyrinth;
import com.game.maze.persist.entity.LabyrinthRoom;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class LabyrinthHelperTests {

    private Labyrinth labyrinth;

    @Before
    public void before() {
       labyrinth = new Labyrinth("First Dimension");
        labyrinth.setSize(10L);
        labyrinth.setId(1L);
        List<LabyrinthRoom> rooms = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++) {
            for (int j = 0 ; j < 10 ; j++) {
                for (int k = 0 ; k < 10 ; k++) {
                    if(i==5 && j==5 && k==5){
                        rooms.add(new LabyrinthRoom(labyrinth.getId(), LabyrinthRoomColor.BLANK, i, j, k));
                    } else {
                        rooms.add(new LabyrinthRoom(labyrinth.getId(), LabyrinthRoomColor.getRandom(), i, j, k));
                    }
                }
            }
        }
        labyrinth.setRooms(rooms);
    }

    @Test
    public void blankRoomSwapUpTest(){
        LabyrinthHelper labyrinthHelper = new LabyrinthHelper(labyrinth);
        int xPrevBlank = labyrinthHelper.getXBlank();
        int yPrevBlank = labyrinthHelper.getYBlank();
        int zPrevBlank = labyrinthHelper.getZBlank();
        labyrinthHelper.moveBlankRoom(Direction.UP);
        LabyrinthRoom blank = labyrinthHelper.getRoomByLocation(xPrevBlank,yPrevBlank + 1,zPrevBlank);
        LabyrinthRoom room = labyrinthHelper.getRoomByLocation(xPrevBlank, yPrevBlank, zPrevBlank);
        Assert.assertTrue(blank.getRoomColor().equals(LabyrinthRoomColor.BLANK));
        Assert.assertFalse(room.getRoomColor().equals(LabyrinthRoomColor.BLANK));
    }

    @Test
    public void blankRoomSwapDownTest(){
        LabyrinthHelper labyrinthHelper = new LabyrinthHelper(labyrinth);
        int xPrevBlank = labyrinthHelper.getXBlank();
        int yPrevBlank = labyrinthHelper.getYBlank();
        int zPrevBlank = labyrinthHelper.getZBlank();
        labyrinthHelper.moveBlankRoom(Direction.DOWN);
        LabyrinthRoom blank = labyrinthHelper.getRoomByLocation(xPrevBlank,yPrevBlank - 1,zPrevBlank);
        LabyrinthRoom room = labyrinthHelper.getRoomByLocation(xPrevBlank, yPrevBlank, zPrevBlank);
        Assert.assertTrue(blank.getRoomColor().equals(LabyrinthRoomColor.BLANK));
        Assert.assertFalse(room.getRoomColor().equals(LabyrinthRoomColor.BLANK));
    }

    @Test
    public void blankRoomSwapNorthTest(){
        LabyrinthHelper labyrinthHelper = new LabyrinthHelper(labyrinth);
        int xPrevBlank = labyrinthHelper.getXBlank();
        int yPrevBlank = labyrinthHelper.getYBlank();
        int zPrevBlank = labyrinthHelper.getZBlank();
        labyrinthHelper.moveBlankRoom(Direction.NORTH);
        LabyrinthRoom blank = labyrinthHelper.getRoomByLocation(xPrevBlank,yPrevBlank,zPrevBlank - 1);
        LabyrinthRoom room = labyrinthHelper.getRoomByLocation(xPrevBlank, yPrevBlank, zPrevBlank);
        Assert.assertTrue(blank.getRoomColor().equals(LabyrinthRoomColor.BLANK));
        Assert.assertFalse(room.getRoomColor().equals(LabyrinthRoomColor.BLANK));
    }

    @Test
    public void blankRoomSwapSouthTest(){
        LabyrinthHelper labyrinthHelper = new LabyrinthHelper(labyrinth);
        int xPrevBlank = labyrinthHelper.getXBlank();
        int yPrevBlank = labyrinthHelper.getYBlank();
        int zPrevBlank = labyrinthHelper.getZBlank();
        labyrinthHelper.moveBlankRoom(Direction.SOUTH);
        LabyrinthRoom blank = labyrinthHelper.getRoomByLocation(xPrevBlank,yPrevBlank,zPrevBlank + 1);
        LabyrinthRoom room = labyrinthHelper.getRoomByLocation(xPrevBlank, yPrevBlank, zPrevBlank);
        Assert.assertTrue(blank.getRoomColor().equals(LabyrinthRoomColor.BLANK));
        Assert.assertFalse(room.getRoomColor().equals(LabyrinthRoomColor.BLANK));
    }

    @Test
    public void blankRoomSwapEastTest(){
        LabyrinthHelper labyrinthHelper = new LabyrinthHelper(labyrinth);
        int xPrevBlank = labyrinthHelper.getXBlank();
        int yPrevBlank = labyrinthHelper.getYBlank();
        int zPrevBlank = labyrinthHelper.getZBlank();
        labyrinthHelper.moveBlankRoom(Direction.EAST);
        LabyrinthRoom blank = labyrinthHelper.getRoomByLocation(xPrevBlank + 1,yPrevBlank,zPrevBlank);
        LabyrinthRoom room = labyrinthHelper.getRoomByLocation(xPrevBlank, yPrevBlank, zPrevBlank);
        Assert.assertTrue(blank.getRoomColor().equals(LabyrinthRoomColor.BLANK));
        Assert.assertFalse(room.getRoomColor().equals(LabyrinthRoomColor.BLANK));
    }

    @Test
    public void blankRoomSwapWestTest(){
        LabyrinthHelper labyrinthHelper = new LabyrinthHelper(labyrinth);
        int xPrevBlank = labyrinthHelper.getXBlank();
        int yPrevBlank = labyrinthHelper.getYBlank();
        int zPrevBlank = labyrinthHelper.getZBlank();
        labyrinthHelper.moveBlankRoom(Direction.WEST);
        LabyrinthRoom blank = labyrinthHelper.getRoomByLocation(xPrevBlank - 1,yPrevBlank,zPrevBlank);
        LabyrinthRoom room = labyrinthHelper.getRoomByLocation(xPrevBlank, yPrevBlank, zPrevBlank);
        Assert.assertTrue(blank.getRoomColor().equals(LabyrinthRoomColor.BLANK));
        Assert.assertFalse(room.getRoomColor().equals(LabyrinthRoomColor.BLANK));
    }
}
