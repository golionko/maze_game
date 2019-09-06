package com.game.maze.persist.entity;

import com.game.maze.model.LabyrinthRoomColor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "labyrinth_room")
public class LabyrinthRoom {

    public LabyrinthRoom(Long labyrinthId, LabyrinthRoomColor roomColor, long x, long y, long z) {
        this.labyrinthId = labyrinthId;
        this.roomColor = roomColor;
        this.xOrigin = x;
        this.yOrigin = y;
        this.zOrigin = z;
        this.xLocation = x;
        this.yLocation = y;
        this.zLocation = z;
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

    @OneToMany(mappedBy = "roomId", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Set<Avatar> avatars;

    @OneToMany(mappedBy = "roomId", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Set<LabyrinthRoomCreature> creatures;
}
