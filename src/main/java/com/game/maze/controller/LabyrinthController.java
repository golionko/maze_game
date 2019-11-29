package com.game.maze.controller;

import com.game.maze.model.MazeStats;
import com.game.maze.service.LabyrinthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LabyrinthController {

    private final LabyrinthService labyrinthService;

    @GetMapping(value = "/maze/create")
    public String createLabyrinth(){
        labyrinthService.createLabyrinth(10);
        return "success";
    }

    @GetMapping(value = "/maze/shuffle/{id}")
    public String shuffleLabyrinth(@PathVariable(name = "id") Long id){
        labyrinthService.shuffleLabyrinthRooms(id);
        return "success";
    }

    @GetMapping(value = "/maze/stats")
    public MazeStats getMazeStats(){
        return labyrinthService.getMazeStats();
    }

}
