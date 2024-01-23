package org.shoppinglistmanager;

import lombok.extern.log4j.Log4j2;
import org.shoppinglistmanager.entity.ShoppingList;
import org.shoppinglistmanager.repository.ShoppingListRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@Log4j2
@SpringBootApplication
public class ShoppingListManager {
    public static void main(String[] args) {
        log.info("Starting Shopping-List Manager");
        SpringApplication.run(ShoppingListManager.class, args);
    }
}