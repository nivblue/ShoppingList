package org.shoppinglistmanager;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class ShoppingListManager {
    public static void main(String[] args) {
        log.info("Starting Shopping-List Manager");
        SpringApplication.run(ShoppingListManager.class, args);
    }
}