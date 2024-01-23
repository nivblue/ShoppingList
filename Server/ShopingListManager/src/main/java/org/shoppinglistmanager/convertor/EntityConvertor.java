package org.shoppinglistmanager.convertor;

import org.listobjects.ShoppingListRest;
import org.shoppinglistmanager.entity.ShoppingList;

/**
 * Convert Rest classes to SQL entities
 */
public class EntityConvertor {
    public static ShoppingList convertToSql(ShoppingListRest shoppingListRest) {
        return ShoppingList.builder()
                .title(shoppingListRest.title())
                .description(shoppingListRest.description())
                .build();
    }
}
