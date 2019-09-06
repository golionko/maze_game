package com.game.maze.controller;

import com.game.maze.persist.entity.Creature;
import com.game.maze.persist.repository.CreatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CreatureController {

    private final CreatureRepository creatureRepository;

    @RequestMapping(value = "/creature", method = RequestMethod.POST)
    public String createCreature(@Valid @ModelAttribute("creature") Creature creature){
        creatureRepository.save(creature);
        return "/";
    }

    @RequestMapping(value = "/creature/{id}", method = RequestMethod.DELETE)
    public String deleteCreature(@PathVariable(name = "id") Long id){
        Optional<Creature> creature = creatureRepository.findById(id);
        creature.ifPresent(creatureRepository::delete);
        return "/";
    }

    @RequestMapping(value = "/creature/{id}", method = RequestMethod.GET)
    public Creature getCreature(@PathVariable(name = "id") Long id){
        Optional<Creature> creature = creatureRepository.findById(id);
        return creature.orElse(null);
    }
}
