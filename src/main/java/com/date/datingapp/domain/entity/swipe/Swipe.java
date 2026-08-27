package com.date.datingapp.domain.entity.swipe;

import com.date.datingapp.domain.enums.SwipeType;
import com.date.datingapp.domain.exception.SwipeError;
import com.date.datingapp.domain.valueobject.swipe.SwipeId;
import com.date.datingapp.domain.valueobject.user.UserId;
import lombok.EqualsAndHashCode;

import java.time.Instant;

@EqualsAndHashCode
public class Swipe {

    private final SwipeId id;
    private final UserId from;
    private final UserId to;
    private final SwipeType type;
    private final Instant createdAt;

    private Swipe(SwipeId id, UserId from, UserId to, SwipeType type, Instant createdAt) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.type = type;
        this.createdAt = createdAt;
    }

    public static Swipe create(UserId from, UserId to) {
        if (from.equals(to)) {
            throw SwipeError.errUserCannotSwipeThemself();
        }
        return new Swipe(SwipeId.generate(), from, to, SwipeType.LIKE, Instant.now());
    }

    public static Swipe restore(SwipeId id, UserId from, UserId to, SwipeType type, Instant createdAt) {
        return new Swipe(id, from, to, type, createdAt);
    }

    public SwipeId getId() {
        return id;
    }

    public UserId getFrom() {
        return from;
    }
    public UserId getTo() {
        return to;
    }

    public SwipeType getType() {
        return type;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
