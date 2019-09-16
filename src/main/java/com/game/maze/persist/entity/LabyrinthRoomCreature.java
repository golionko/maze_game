package com.game.maze.persist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "labyrinth_room_creature")
public class LabyrinthRoomCreature {

    public LabyrinthRoomCreature(Creature creature, Long roomId) {
        this.creature = creature;
        this.roomId = roomId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "creature_id")
    private Creature creature;

    @Column(name = "labyrinth_room_id")
    private Long roomId;
}
