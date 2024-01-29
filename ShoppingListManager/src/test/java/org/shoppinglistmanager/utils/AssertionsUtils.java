package org.shoppinglistmanager.utils;

import org.junit.jupiter.api.Assertions;
import org.listobjects.ShoppingListRest;

public class AssertionsUtils {
    public static void AssertShoppingListRest(ShoppingListRest actual, ShoppingListRest expected) {
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(actual.id(), expected.id());
        Assertions.assertEquals(actual.title(), expected.title());
        Assertions.assertEquals(actual.description(), expected.description());
        Assertions.assertEquals(actual.title(), expected.title()); // TODO: implement items assertions
    }
}
