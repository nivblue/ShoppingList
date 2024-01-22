package org.listcontroller.listener;

import lombok.extern.log4j.Log4j2;
import org.listobjects.kafka.Item;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
//@Component
public class listUpdateListener { // TODO: implement

//    @KafkaListener(topics = "LIST_UPDATE", groupId = "groupId")
    public void listUpdated(Item item) {
        log.info("Received update for item : " + item);
    } //Item item
}
