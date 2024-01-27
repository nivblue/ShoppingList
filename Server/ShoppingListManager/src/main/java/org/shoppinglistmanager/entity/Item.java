package org.shoppinglistmanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;
    private int count;
    private String title;
    private String description;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShoppingList_id")
    private ShoppingList shoppingList;

    public Item(int count, String title, String description, ShoppingList shoppingList) {
        this.count = count;
        this.title = title;
        this.description = description;
        this.shoppingList = shoppingList;
    }
}
