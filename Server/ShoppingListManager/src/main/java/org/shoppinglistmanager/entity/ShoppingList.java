package org.shoppinglistmanager.entity;


import jakarta.persistence.*;
import lombok.*;

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
    private List<Item> listOfItems = new ArrayList<>();

    public ShoppingList(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
