package com.date.datingapp.domain.valueobject;

import java.util.Objects;
import java.util.UUID;

public record MatchId(UUID value) {

    public MatchId{
        Objects.requireNonNull(value);
    }

    public static MatchId generate() {
        return new MatchId(UUID.randomUUID());
    }

    public static MatchId of(UUID value) {
        return new MatchId(value);
    }
}
