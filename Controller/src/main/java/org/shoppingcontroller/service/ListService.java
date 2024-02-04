package org.shoppingcontroller.service;

import org.listobjects.entity.ShoppingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ListService {

    @Autowired
    private KafkaTemplate<String, ShoppingList> shoppingListProducer;

    public ResponseEntity<Integer> createNewShoppingList(ShoppingList shoppingList) {
        return null; // implement
    }

    public ResponseEntity<ShoppingList> getShoppingListById(int id) {
        return null; // implement
    }
}
