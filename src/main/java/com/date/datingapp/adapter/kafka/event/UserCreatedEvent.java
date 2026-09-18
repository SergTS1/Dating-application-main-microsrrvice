package com.date.datingapp.adapter.kafka.event;

import java.util.UUID;

public record UserCreatedEvent(
        UUID userId
) {
}
