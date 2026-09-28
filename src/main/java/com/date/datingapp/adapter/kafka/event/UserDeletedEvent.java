package com.date.datingapp.adapter.kafka.event;

import java.util.UUID;

public record UserDeletedEvent(
        UUID userId
) {
}
