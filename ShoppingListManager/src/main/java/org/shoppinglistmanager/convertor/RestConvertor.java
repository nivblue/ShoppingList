package org.shoppinglistmanager.convertor;

import org.listobjects.ItemRest;
import org.listobjects.ShoppingListRest;
import org.listobjects.entity.Item;
import org.listobjects.entity.ShoppingList;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RestConvertor {

    public static ShoppingListRest convertToRest(ShoppingList shoppingList) {
        return ShoppingListRest.builder()
                .id(shoppingList.getId())
                .title(shoppingList.getTitle())
                .description(shoppingList.getDescription())
                .itemRests(convertToItemsList(shoppingList.getListOfItems()))
                .build();
    }

    public static ItemRest convertToRest(Item item) {
        return ItemRest.builder()
                .id(item.getId())
                .title(item.getTitle())
                .description(item.getDescription())
                .count(item.getCount())
                .build();
    }

    private static Set<ItemRest> convertToItemsList(List<Item> listOfItems) {
        return listOfItems.stream()
                .map(RestConvertor::convertToRest)
                .collect(Collectors.toSet());
    }
}
