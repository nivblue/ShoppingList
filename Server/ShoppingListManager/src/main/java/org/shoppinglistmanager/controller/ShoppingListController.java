package org.shoppinglistmanager.controller;

import org.listobjects.ItemRest;
import org.listobjects.ShoppingListRest;
import org.shoppinglistmanager.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/lists/")
public class ShoppingListController {
    @Autowired
    ShoppingListService shoppingListService;

    @PostMapping("/create/")
    public ResponseEntity<Integer> createShoppingList(@RequestBody ShoppingListRest shoppingListRest) {
        return shoppingListService.createShoppingList(shoppingListRest);
    }

    @PutMapping("/{id}/newItem/")
    public ResponseEntity<Integer> addNewItemToList(@PathVariable Integer id,
                                                     @RequestBody ItemRest itemRest) {
        return shoppingListService.addNewItemToList(id, itemRest);
    }

    @PutMapping("/{listId}/updateItem/")
    public ResponseEntity<Integer> updateNewItemToList(@PathVariable Integer listId,
                                                    @RequestBody ItemRest itemRest) {
        return shoppingListService.updateItem(listId, itemRest);
    }

    @GetMapping("/{id}/")
    public ResponseEntity<ShoppingListRest> getShoppingListById(@PathVariable Integer id) {
        return shoppingListService.getShoppingListById(id);
    }
}
