package org.shoppinglistmanager.utils;

import org.listobjects.ShoppingListRest;

import java.util.Collections;

public class TestUtils {
    public static ShoppingListRest createShoppingListRest(int id) {
        return ShoppingListRest.builder()
                .id(id)
                .title("test title")
                .description("test desc")
                .itemRests(Collections.emptySet())
                .build();
    }
}
