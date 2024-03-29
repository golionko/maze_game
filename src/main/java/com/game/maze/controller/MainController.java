package com.game.maze.controller;

import com.game.maze.model.view.UserView;
import com.game.maze.persist.repository.AvatarRepository;
import com.game.maze.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final AvatarRepository avatarRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String init(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserView userView = new UserView();
        if (principal instanceof UserDetails) {
            UserPrincipal user = ((UserPrincipal) principal);
            userView.setId(user.getId());
            userView.setName(user.getUsername());
            userView.setAvatars(avatarRepository.findAllByUserId(user.getId()));
            model.addAttribute("user",userView);
        }
        return "index";
    }
}
