package com.game.maze.controller.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSummary {
    private Long id;
    private String username;
    private String image = "https://pbs.twimg.com/profile_images/626949233/SquareCat.jpg";

    public UserSummary(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}
