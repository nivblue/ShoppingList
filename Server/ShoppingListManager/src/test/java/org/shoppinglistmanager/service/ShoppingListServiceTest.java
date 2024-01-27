package org.shoppinglistmanager.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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
import org.shoppinglistmanager.utils.TestUtils;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ShoppingListServiceTest {
    @Mock
    private ShoppingListRepository shoppingListRepository;

    @InjectMocks
    private ShoppingListService shoppingListService;

    @BeforeAll
    static void init() {

    }

    @Test
    @DisplayName("Check get shopping list by existing id retrieve the right shopping list")
    void testGetShoppingListByExistingIdRetrievesRightList() {
        ShoppingListRest expectedShoppingListRest = TestUtils.createShoppingListRest(1);
        ShoppingList expectedShoppingList = EntityConvertor.convertToSql(expectedShoppingListRest);

        when(shoppingListRepository
                .findById(expectedShoppingList.getId()))
                .thenReturn(Optional.of(expectedShoppingList));

        ShoppingListRest actualShoppingList = shoppingListService.getShoppingListById(1).getBody();

        Assertions.assertNotNull(actualShoppingList);
        Assertions.assertEquals(actualShoppingList.id(), expectedShoppingListRest.id());
        Assertions.assertEquals(actualShoppingList.title(), expectedShoppingListRest.title());
    }
}
