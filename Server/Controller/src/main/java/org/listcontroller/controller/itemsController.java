package org.listcontroller.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list")
public class itemsController {
    @GetMapping("/{id}/item")
    public ResponseEntity<> getItemById(@PathVariable int id) {
        return
    }
}
