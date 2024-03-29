package com.game.maze.persist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "avatar_item_inventory")
public class AvatarItemInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    private Item item;

    @Column(name = "avatar_id")
    private Long avatarId;

    @Column(name = "amount")
    private Long amount;

}
