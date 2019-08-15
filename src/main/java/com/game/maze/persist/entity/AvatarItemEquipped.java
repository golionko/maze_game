package com.game.maze.persist.entity;

import com.game.maze.model.BodyPart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "avatar_item_equipped")
public class AvatarItemEquipped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "avatar_id")
    private String avatarId;

    @Column(name = "body_part")
    @Enumerated(EnumType.STRING)
    private BodyPart bodyPart;
}
