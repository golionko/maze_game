package com.game.maze.persist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "avatar")
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    private String name;
    private Long xp;
    private Long level;
    private Long strength;
    private Long dexterity;
    private Long luck;
    private Long constitution;
    private Long hp;
    private Long energy;
    @Column(name = "labyrinth_room_id")
    private Long roomId;
}
