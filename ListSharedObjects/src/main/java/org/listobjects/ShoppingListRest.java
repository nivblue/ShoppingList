package org.listobjects;

import lombok.Builder;
import java.util.Set;

@Builder
public record ShoppingListRest(
        int id,
        String title,
        String description,
        Set<ItemRest> itemRests
){ }
