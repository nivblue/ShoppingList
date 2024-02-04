package org.shoppinglistmanager.utils;

import org.junit.jupiter.api.Assertions;
import org.listobjects.entity.ShoppingList;

public class AssertionsUtils {
    public static void AssertShoppingList(ShoppingList actual, ShoppingList expected) {
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(actual.getId(), expected.getId());
        Assertions.assertEquals(actual.getTitle(), expected.getTitle());
        Assertions.assertEquals(actual.getDescription(), expected.getDescription());
    }
}
