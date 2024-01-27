package org.listobjects;

import lombok.Builder;

@Builder
public record ItemRest(
    int id,
    Integer count,
    String title,
    String description
) { }
