package com.game.maze.persist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "creature")
public class Creature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long xp;
    private Long level;
    private Long strength;
    private Long dexterity;
    private Long luck;
    private Long constitution;
    private Long hp;
    @Column(name = "max_hp")
    private Long maxHp;
    private Long energy;
    @Column(name = "max_energy")
    private Long maxEnergy;
}
