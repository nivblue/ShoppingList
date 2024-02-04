package org.shoppinglistmanager.controller;

import lombok.extern.log4j.Log4j2;
import org.listobjects.ShoppingListRest;
import org.listobjects.entity.Item;
import org.listobjects.entity.ShoppingList;
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
    public ResponseEntity<Integer> createShoppingList(@RequestBody ShoppingList shoppingList) {
        log.debug("Creating new shopping titled : " + shoppingList.getTitle());
        return shoppingListService.createShoppingList(shoppingList);
    }

    @PutMapping("/{id}/newItem")
    public ResponseEntity<Integer> addNewItemToList(@PathVariable Integer listId,
                                                     @RequestBody Item item) {
        log.debug("Adding new item " + item.getTitle() + " in shopping list with id : " + listId);
        return shoppingListService.addNewItemToList(listId, item);
    }

    @PutMapping("/{listId}/updateItem")
    public ResponseEntity<Integer> updateNewItemToList(@PathVariable Integer listId,
                                                    @RequestBody Item itemRest) {
        log.debug("Updating item with id " + itemRest.getId() + " in shopping list with id : " + listId);
        return shoppingListService.updateItem(listId, itemRest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingList> getShoppingListById(@PathVariable Integer id) {
        log.debug("Getting shopping list for id : " + id);
        return shoppingListService.getShoppingListById(id);
    }

    @GetMapping("/dev/debug/item/{id}") // TODO: add admin security check
    public ResponseEntity<Item> getItemByIds(@PathVariable Integer id) {
        log.debug("[Admin] Getting item for id : " + id);
        return shoppingListService.getItemByIds(id);
    }
}
