package org.shoppinglistmanager.service;

import org.listobjects.ItemRest;
import org.listobjects.ShoppingListRest;
import org.shoppinglistmanager.convertor.EntityConvertor;
import org.shoppinglistmanager.convertor.RestConvertor;
import org.shoppinglistmanager.entity.Item;
import org.shoppinglistmanager.entity.ShoppingList;
import org.shoppinglistmanager.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingListService {

    @Autowired
    ShoppingListRepository shoppingListRepository;

    public ResponseEntity<Integer> createShoppingList(ShoppingListRest shoppingListRest) {
        ShoppingList savedList = shoppingListRepository.save(EntityConvertor.convertToSql(shoppingListRest));
        return ResponseEntity.ok(savedList.getId());
    }

    public ResponseEntity<ShoppingListRest> getShoppingListById(int id) {
        return shoppingListRepository.findById(id)
                .map(RestConvertor::convertShoppingListToRest)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }


    public ResponseEntity<Integer> updateNewItemToList(Integer id, ItemRest itemRest) {
        return null;
    }

    public ResponseEntity<Integer> addNewItemToList(Integer id, ItemRest itemRest) {
        return shoppingListRepository.findById(id)
                .map((ShoppingList shoppingList) -> addNewItemToList(shoppingList, itemRest))
                .filter((Integer i) -> i != -1)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    private Integer addNewItemToList(ShoppingList shoppingList, ItemRest itemRest) {
        ArrayList<Item> listOfItems = (ArrayList<Item>) shoppingList.getListOfItems();
        Optional<Item> existingItem = getExistingItem(listOfItems, itemRest);

        existingItem.ifPresent(listOfItems::remove);
        existingItem
                .map((Item item) -> {
                    item.setCount(item.getCount() + itemRest.count());
                    return item;
                })
                .ifPresent(listOfItems::add);

        if (existingItem.isEmpty()) {
            listOfItems.add(
                    new Item(itemRest.count(),
                            itemRest.count(),
                            itemRest.title(),
                            itemRest.description(),
                            shoppingList));
        } else {
            return existingItem.map(Item::getId).get();
        }

        shoppingList.setListOfItems(listOfItems);

        return shoppingListRepository.save(shoppingList)
                .getListOfItems()
                .stream()
                .filter((Item item) -> item.getTitle().equalsIgnoreCase(itemRest.title()))
                .findAny()
                .map(Item::getId)
                .orElse(-1);
    }

    private Optional<Item> getExistingItem(List<Item> listOfItems, ItemRest itemRest) {
        return listOfItems.stream()
                .filter((Item item) -> item.getTitle().equalsIgnoreCase(itemRest.title()))
                .findAny();
    }
}