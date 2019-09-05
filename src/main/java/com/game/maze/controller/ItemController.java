package com.game.maze.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.game.maze.persist.entity.Item;
import com.game.maze.persist.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;

    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public String createItem(@Valid @ModelAttribute("data") String data) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        final Item item = mapper.readValue(data, Item.class);
        if(item.getBuffs() != null){
            item.getBuffs().forEach(itemBuff -> itemBuff.setItem(item));
        }
        itemRepository.save(item);
        return "admin_items";
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
    public String deleteItem(@PathVariable(name = "id") Long id){
        Optional<Item> item = itemRepository.findById(id);
        if(item.isPresent()){
            itemRepository.delete(item.get());
        }
        return "admin_items";
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
