package com.game.maze.controller;

import com.game.maze.controller.payload.UserSummary;
import com.game.maze.security.CurrentUser;
import com.game.maze.security.UserPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/me")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername());
        return userSummary;
    }
}
