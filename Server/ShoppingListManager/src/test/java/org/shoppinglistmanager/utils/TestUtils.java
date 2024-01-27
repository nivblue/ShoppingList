package org.shoppinglistmanager.utils;

import org.junit.jupiter.api.Assertions;
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

    public static void AssertShoppingListRest(ShoppingListRest actual, ShoppingListRest expected) {
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(actual.id(), expected.id());
        Assertions.assertEquals(actual.title(), expected.title());
        Assertions.assertEquals(actual.description(), expected.description());
        Assertions.assertEquals(actual.title(), expected.title()); // TODO: implement items assertions
    }
}
