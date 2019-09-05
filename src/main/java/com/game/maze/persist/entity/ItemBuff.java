package com.game.maze.persist.entity;

import com.game.maze.model.AvatarStat;
import com.game.maze.model.ItemBuffType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item_buff")
public class ItemBuff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne( fetch = FetchType.EAGER )
    @JoinColumn(name = "item_id", nullable = false , referencedColumnName = "id")
    private Item item;

    @Column(name = "buff_type")
    @Enumerated(EnumType.STRING)
    private ItemBuffType itemBuffType;

    @Column(name = "stat")
    @Enumerated(EnumType.STRING)
    private AvatarStat stat;

    @Column(name = "amount")
    private Long amount;
}
