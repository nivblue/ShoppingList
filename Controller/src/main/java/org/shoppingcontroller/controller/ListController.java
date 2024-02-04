package org.shoppingcontroller.controller;

import org.listobjects.entity.ShoppingList;
import org.shoppingcontroller.service.ListService;
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
    public ResponseEntity<Integer> createList(ShoppingList shoppingList) {
        return listService.createNewShoppingList(shoppingList);
    }


    @GetMapping("/{id}/")
    public ResponseEntity<ShoppingList> getShoppingListById(@PathVariable int id) {
        return listService.getShoppingListById(id);
    }
}
