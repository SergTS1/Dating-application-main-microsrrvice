package com.date.datingapp.adapter.kafka;


import com.date.datingapp.adapter.kafka.event.UserCreatedEvent;
import com.date.datingapp.adapter.kafka.event.UserDeletedEvent;
import com.date.datingapp.boundary.usecase.UserReferenceUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEventConsumer {

    private final UserReferenceUseCase userReferenceUseCase;

    @KafkaListener(
            topics = "user.created",
            groupId = "match-service",
            containerFactory = "userCreatedKafkaListenerContainerFactory"
    )
    public void consumeUserCreated(UserCreatedEvent event) {
        userReferenceUseCase.createUserReference(event.userId());
    }

    @KafkaListener(
            topics = "user.deleted",
            groupId = "match-service",
            containerFactory = "userDeletedKafkaListenerContainerFactory"
    )
    public void consumeUserDeleted(UserDeletedEvent event) {
        userReferenceUseCase.deleteUserReference(event.userId());
    }
}
