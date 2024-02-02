package org.shoppinglistmanager.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.listobjects.ShoppingListRest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.shoppinglistmanager.service.ShoppingListService;
import org.shoppinglistmanager.utils.AssertionsUtils;
import org.shoppinglistmanager.utils.TestUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ShoppingListControllerTest {
    @Mock
    private ShoppingListService shoppingListService;

    @InjectMocks
    private ShoppingListController shoppingListController;

    @Test
    @DisplayName("Test that getShoppingListById for existing id return the right shopping list")
    void testGetShoppingListExistIdReturnDesiredShoppingList() {
        int id = 1;
        ShoppingListRest expectedShoppingListRest = TestUtils.createShoppingListRest(id);
        when(shoppingListService.getShoppingListById(id)).thenReturn(ResponseEntity.ok(expectedShoppingListRest));

        ResponseEntity<ShoppingListRest> actualResponse = shoppingListController.getShoppingListById(id);

        AssertionsUtils.AssertShoppingListRest(expectedShoppingListRest, actualResponse.getBody());
        Assertions.assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
    }

    @Test
    @DisplayName("Test that getShoppingListById for non existing id return not found status code")
    void testGetShoppingListNonExistingIdReturnDesiredShoppingList() {
        int id = 1;
        ShoppingListRest expectedShoppingListRest = TestUtils.createShoppingListRest(id);
        lenient().when(shoppingListService.getShoppingListById(id)).thenReturn(ResponseEntity.ok(expectedShoppingListRest));
        lenient().when(shoppingListService.getShoppingListById(anyInt())).thenReturn(ResponseEntity.notFound().build());

        HttpStatusCode actualStatusCode = shoppingListController.getShoppingListById(0).getStatusCode();

        Assertions.assertEquals(actualStatusCode, HttpStatus.NOT_FOUND);
    }
}
