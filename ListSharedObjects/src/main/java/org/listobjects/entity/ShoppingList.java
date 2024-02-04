package org.listobjects.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ShoppingList {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer id;
    private String title;
    private String description;

    @OneToMany(mappedBy = "shoppingList",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private final List<Item> listOfItems = new ArrayList<>(); // TODO: Need to be set to final, and then be checked

    public ShoppingList(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
