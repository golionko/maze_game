package com.game.maze.controller;

import com.game.maze.controller.payload.UserSummary;
import com.game.maze.persist.entity.Avatar;
import com.game.maze.persist.repository.AvatarRepository;
import com.game.maze.security.CurrentUser;
import com.game.maze.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final AvatarRepository avatarRepository;

    @GetMapping("/user/me")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername());
        List<Avatar> avatars = avatarRepository.findAllByUserId(currentUser.getId());
        userSummary.setAvatarId(avatars != null ? avatars.get(0).getId() : 1L);
        return userSummary;
    }
}
