package org.shoppinglistmanager.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.listobjects.ShoppingListRest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.shoppinglistmanager.convertor.EntityConvertor;
import org.shoppinglistmanager.convertor.RestConvertor;
import org.shoppinglistmanager.entity.ShoppingList;
import org.shoppinglistmanager.repository.ShoppingListRepository;
import org.shoppinglistmanager.utils.AssertionsUtils;
import org.shoppinglistmanager.utils.TestUtils;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ShoppingListServiceTest {
    @Mock
    private ShoppingListRepository shoppingListRepository;
    @InjectMocks
    private ShoppingListService shoppingListService;

    @Test
    @DisplayName("Check get shopping list by existing id retrieve the right shopping list")
    void testGetShoppingListByExistingIdRetrievesRightList() {
        int id = 1;
        ShoppingList expectedShoppingList = TestUtils.createShoppingList(id);
        ShoppingListRest expectedShoppingListRest = RestConvertor.convertToRest(expectedShoppingList);

        when(shoppingListRepository.findById(id)).thenReturn(Optional.of(expectedShoppingList));

        ShoppingListRest actualShoppingListRest = shoppingListService.getShoppingListById(id).getBody();

        AssertionsUtils.AssertShoppingListRest(actualShoppingListRest, expectedShoppingListRest);
    }
}