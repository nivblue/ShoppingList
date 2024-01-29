package org.shoppinglistmanager.convertor;

import org.listobjects.ItemRest;
import org.listobjects.ShoppingListRest;
import org.shoppinglistmanager.entity.Item;
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

    public static Item convertToSql(ItemRest itemRest) {
        return Item.builder()
                .count(itemRest.count())
                .title(itemRest.title())
                .description(itemRest.description())
                .build();
    }
}
