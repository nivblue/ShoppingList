package org.listcontroller;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class Main { // Change Main class name
    public static void main(String[] args) {
        log.info("Starting Producer");
        SpringApplication.run(Main.class, args);
    }
}