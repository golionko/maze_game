package com.game.maze.persist.entity;

import com.game.maze.model.LabyrinthRoomColor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "labyrinth_room")
public class LabyrinthRoom {

    public LabyrinthRoom(Long labyrinthId, LabyrinthRoomColor roomColor, int x, int y, int z) {
        this.labyrinthId = labyrinthId;
        this.roomColor = roomColor;
        this.xOrigin = new Long(x);
        this.yOrigin = new Long(y);
        this.zOrigin = new Long(z);
        this.xLocation = new Long(x);
        this.yLocation = new Long(y);
        this.zLocation = new Long(z);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "labyrinth_id")
    private Long labyrinthId;
    @Column(name = "room_color")
    @Enumerated(EnumType.STRING)
    private LabyrinthRoomColor roomColor;

    @Column(name = "x_origin")
    private Long xOrigin;
    @Column(name = "y_origin")
    private Long yOrigin;
    @Column(name = "z_origin")
    private Long zOrigin;

    @Column(name = "x_location")
    private Long xLocation;
    @Column(name = "y_location")
    private Long yLocation;
    @Column(name = "z_location")
    private Long zLocation;

}
