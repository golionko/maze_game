package com.game.maze.controller;

import com.game.maze.persist.entity.Item;
import com.game.maze.persist.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public String createItem(@RequestBody Item item){
        itemRepository.save(item);
        return "/";
    }

    @RequestMapping(value = "/item", method = RequestMethod.DELETE)
    public String deleteItem(@RequestBody Item item){
        itemRepository.delete(item);
        return "/";
    }
}
