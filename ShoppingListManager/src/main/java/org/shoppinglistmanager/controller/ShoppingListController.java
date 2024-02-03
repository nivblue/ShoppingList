package org.shoppinglistmanager.controller;

import lombok.extern.log4j.Log4j2;
import org.listobjects.ItemRest;
import org.listobjects.ShoppingListRest;
import org.listobjects.entity.Item;
import org.shoppinglistmanager.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
@RequestMapping("/lists")
public class ShoppingListController {
    @Autowired
    ShoppingListService shoppingListService;

    @PostMapping("/create")
    public ResponseEntity<Integer> createShoppingList(@RequestBody ShoppingListRest shoppingListRest) {
        log.debug("Creating new shopping titled : " + shoppingListRest.title());
        return shoppingListService.createShoppingList(shoppingListRest);
    }

    @PutMapping("/{id}/newItem")
    public ResponseEntity<Integer> addNewItemToList(@PathVariable Integer listId,
                                                     @RequestBody ItemRest itemRest) {
        log.debug("Adding new item " + itemRest.title() + " in shopping list with id : " + listId);
        return shoppingListService.addNewItemToList(listId, itemRest);
    }

    @PutMapping("/{listId}/updateItem")
    public ResponseEntity<Integer> updateNewItemToList(@PathVariable Integer listId,
                                                    @RequestBody ItemRest itemRest) {
        log.debug("Updating item with id " + itemRest.id() + " in shopping list with id : " + listId);
        return shoppingListService.updateItem(listId, itemRest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingListRest> getShoppingListById(@PathVariable Integer id) {
        log.debug("Getting shopping list for id : " + id);
        return shoppingListService.getShoppingListById(id);
    }

    @GetMapping("/dev/debug/item/{id}") // TODO: add admin security check
    public ResponseEntity<Item> getItemByIds(@PathVariable Integer id) {
        log.debug("[Admin] Getting item for id : " + id);
        return shoppingListService.getItemByIds(id);
    }
}
