package org.shoppingcontroller.service;

import org.listobjects.rest.ShoppingListRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ListService {

    @Autowired
    private KafkaTemplate<String, ShoppingListRest> shoppingListProducer;

    public ResponseEntity<Integer> createNewShoppingList(ShoppingListRest shoppingListRest) {
        return null; // implement
    }

    public ResponseEntity<ShoppingListRest> getShoppingListById(int id) {
        return null; // implement
    }
}
