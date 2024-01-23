package org.listobjects;

import lombok.Builder;

@Builder
public record ItemRest(
    int id,
    int listId,
    int count,
    String title,
    String description
) { }
