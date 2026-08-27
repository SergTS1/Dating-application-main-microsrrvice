package com.date.datingapp.domain.valueobject.swipe;

import java.util.Objects;
import java.util.UUID;

public record SwipeId(UUID value) {

    public SwipeId {
        Objects.requireNonNull(value);
    }

    public static SwipeId generate() {
        return new SwipeId(UUID.randomUUID());
    }

    public static SwipeId of(UUID value) {
        return new SwipeId(value);
    }
}
