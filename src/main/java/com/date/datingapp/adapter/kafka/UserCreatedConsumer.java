package com.date.datingapp.adapter.kafka;


import com.date.datingapp.adapter.kafka.event.UserCreatedEvent;
import com.date.datingapp.boundary.usecase.UserCreatedUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCreatedConsumer {

    private final UserCreatedUseCase userCreatedUseCase;

    @KafkaListener(
            topics = "user.created",
            groupId = "match-service",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume(UserCreatedEvent event) {
        userCreatedUseCase.execute(event.userId());
    }
}
