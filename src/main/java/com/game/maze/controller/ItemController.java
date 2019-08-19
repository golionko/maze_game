package com.game.maze.controller;

import com.game.maze.persist.entity.Item;
import com.game.maze.persist.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public String createItem(@RequestBody Item item){
        itemRepository.save(item);
        return "/";
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
    public String deleteItem(@PathVariable(name = "id") Long id){
        Optional<Item> item = itemRepository.findById(id);
        if(item.isPresent()){
            itemRepository.delete(item.get());
        }
        return "/";
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public Item getItem(@PathVariable(name = "id") Long id){
        Optional<Item> item = itemRepository.findById(id);
        if(item.isPresent()){
            return item.get();
        }
        return null;
    }
}
