package org.shoppinglistmanager.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.listobjects.ShoppingListRest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.shoppinglistmanager.convertor.EntityConvertor;
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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hello");


        int id = 1;
        ShoppingListRest expectedShoppingListRest = TestUtils.createShoppingListRest(id);
        ShoppingList expectedShoppingList = EntityConvertor.convertToSql(expectedShoppingListRest);

        when(shoppingListRepository.findById(1)).thenReturn(Optional.of(expectedShoppingList));

        ShoppingListRest actualShoppingListRest = shoppingListService.getShoppingListById(1).getBody();

        AssertionsUtils.AssertShoppingListRest(actualShoppingListRest, expectedShoppingListRest);
    }
}