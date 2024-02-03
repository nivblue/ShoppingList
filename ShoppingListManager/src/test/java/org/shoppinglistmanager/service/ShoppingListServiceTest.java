package org.shoppinglistmanager.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.shoppinglistmanager.repository.ShoppingListRepository;

@ExtendWith(MockitoExtension.class)
public class ShoppingListServiceTest {
    @Mock
    private ShoppingListRepository shoppingListRepository;

    @InjectMocks
    private ShoppingListService shoppingListService;

    @BeforeAll
    static void init() {

    }

//    @Test
//    @DisplayName("Check get shopping list by existing id retrieve the right shopping list")
//    void testGetShoppingListByExistingIdRetrievesRightList() {
//        ShoppingListRest expectedShoppingListRest = TestUtils.createShoppingListRest(1);
//        ShoppingList expectedShoppingList = EntityConvertor.convertToSql(expectedShoppingListRest);
//
//        when(shoppingListRepository
//                .findById(expectedShoppingList.getId()))
//                .thenReturn(Optional.of(expectedShoppingList));
//
//        ShoppingListRest actualShoppingListRest = shoppingListService.getShoppingListById(1).getBody();
//
//        AssertionsUtils.AssertShoppingListRest(actualShoppingListRest, expectedShoppingListRest);
//    }
}
