package org.shoppingcontroller.listener;

import lombok.extern.log4j.Log4j2;
import org.listobjects.rest.ShoppingListRest;

@Log4j2
//@Component
public class ListUpdateListener { // TODO: implement

//    @KafkaListener(topics = "LIST_UPDATE", groupId = "groupId")
    public void listUpdated(ShoppingListRest shoppingListRest) {
        log.info("Received update for item : " + shoppingListRest);
    }
}