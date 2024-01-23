package org.shoppingcontroller.controller;

import org.shoppingcontroller.service.ListService;
import org.listobjects.ShoppingListRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shopping")
public class ListController {

    @Autowired
    ListService listService;


    @PostMapping("/list")
    public ResponseEntity<Integer> createList(ShoppingListRest shoppingListRest) {
        return listService.createNewShoppingList(shoppingListRest);
    }


    @GetMapping("/{id}/")
    public ResponseEntity<ShoppingListRest> getShoppingListById(@PathVariable int id) {
        return listService.getShoppingListById(id);
    }
}
