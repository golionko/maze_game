package com.game.maze.persist.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "max_hp")
    private Long maxHp;
    private Long energy;
    @Column(name = "max_energy")
    private Long maxEnergy;
    @Column(name = "labyrinth_room_id")
    private Long roomId;

    @OneToMany(mappedBy = "avatarId", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<AvatarItemEquipped> equipped;

    @OneToMany(mappedBy = "avatarId", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<AvatarItemInventory> inventory;
}
