package org.shoppinglistmanager.service;

import org.listobjects.entity.Item;
import org.listobjects.entity.ShoppingList;
import org.shoppinglistmanager.repository.ItemRepository;
import org.shoppinglistmanager.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ShoppingListService {

    @Autowired
    ShoppingListRepository shoppingListRepository;

    @Autowired
    ItemRepository itemRepository;

    public ResponseEntity<Integer> createShoppingList(ShoppingList shoppingList) {
        ShoppingList savedList = shoppingListRepository.save(shoppingList);
        return ResponseEntity.ok(savedList.getId());
    }

    public ResponseEntity<ShoppingList> getShoppingListById(int id) {
        return shoppingListRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }


    public ResponseEntity<Integer> addNewItemToList(Integer listId, Item item) {
        return shoppingListRepository.findById(listId)
                .map((ShoppingList shoppingList) -> saveNewItem(shoppingList, item))
                .map(Item::getId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    public ResponseEntity<Integer> updateItem(Integer listId, Item updateItem) {
        Optional<Item> item = shoppingListRepository.findById(listId)
                .map(ShoppingList::getListOfItems)
                .flatMap((List<Item> listOfItems) -> findMatchingItemById(listOfItems, updateItem.getId()))
                .map((Item modifyItem) -> updateItemValues(modifyItem, updateItem));

        return item
                .map(itemRepository::save)
                .map(Item::getId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    public ResponseEntity<Item> getItemByIds(Integer id) {
        return itemRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    private Optional<Item> findMatchingItemById(List<Item> listOfItems, int id) {
        return listOfItems.stream()
                .filter((Item item) -> item.getId() == id)
                .findFirst();
    }

    private Item updateItemValues(Item item, Item updateItem) {
        return Item.builder()
                .id(item.getId())
                .count(Objects.nonNull(updateItem.getCount()) ? updateItem.getCount() : item.getCount())
                .title(Objects.nonNull(updateItem.getTitle()) ? updateItem.getTitle() : item.getTitle())
                .description(Objects.nonNull(updateItem.getDescription()) ? updateItem.getDescription() : item.getDescription())
                .shoppingList(item.getShoppingList())
                .build();
    }

    private Item saveNewItem(ShoppingList shoppingList, Item item) {
        item.setShoppingList(shoppingList);

        return itemRepository.save(item);
    }
}