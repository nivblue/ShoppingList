package org.shoppinglistmanager.service;

import org.listobjects.ItemRest;
import org.listobjects.ShoppingListRest;
import org.shoppinglistmanager.convertor.EntityConvertor;
import org.shoppinglistmanager.convertor.RestConvertor;
import org.shoppinglistmanager.entity.Item;
import org.shoppinglistmanager.entity.ShoppingList;
import org.shoppinglistmanager.repository.ItemRepository;
import org.shoppinglistmanager.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ShoppingListService {

    @Autowired
    ShoppingListRepository shoppingListRepository;

    @Autowired
    ItemRepository itemRepository;

    public ResponseEntity<Integer> createShoppingList(ShoppingListRest shoppingListRest) {
        ShoppingList savedList = shoppingListRepository.save(EntityConvertor.convertToSql(shoppingListRest));
        return ResponseEntity.ok(savedList.getId());
    }

    public ResponseEntity<ShoppingListRest> getShoppingListById(int id) {
        return shoppingListRepository.findById(id)
                .map(RestConvertor::convertToRest)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }


    public ResponseEntity<Integer> updateItem(Integer listId, ItemRest itemRest) {
        Optional<Item> item = shoppingListRepository.findById(listId)
                .map(ShoppingList::getListOfItems)
                .flatMap((List<Item> listOfItems) -> findMatchingItem(listOfItems, itemRest))
                .map((Item modifyItem) -> updateItem(modifyItem, itemRest));

        return item
                .map(itemRepository::save)
                .map(Item::getId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    public ResponseEntity<Integer> addNewItemToList(Integer id, ItemRest itemRest) {
        return shoppingListRepository.findById(id)
                .map((ShoppingList shoppingList) -> saveNewItem(shoppingList, itemRest))
                .map(Item::getId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    private Optional<Item> findMatchingItem(List<Item> listOfItems, ItemRest itemRest) {
        return listOfItems.stream()
                .filter((Item item) -> item.getId() == itemRest.id())
                .findFirst();
    }

    private Item updateItem(Item item, ItemRest itemRest) {
        return Item.builder()
                .id(item.getId())
                .count(Objects.nonNull(itemRest.count()) ? itemRest.count() : item.getCount())
                .title(Objects.nonNull(itemRest.title()) ? itemRest.title() : item.getTitle())
                .description(Objects.nonNull(itemRest.description()) ? itemRest.description() : item.getDescription())
                .shoppingList(item.getShoppingList())
                .build();
    }

    private Item saveNewItem(ShoppingList shoppingList, ItemRest itemRest) {
        Item newItem = Item.builder()
                .count(itemRest.count())
                .title(itemRest.title())
                .description(itemRest.description())
                .shoppingList(shoppingList)
                .build();

        return itemRepository.save(newItem);
    }
}