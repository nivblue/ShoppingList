package org.listobjects.kafka;

public record Item(
    int id,
    int count,
    String title,
    String description
) { }
