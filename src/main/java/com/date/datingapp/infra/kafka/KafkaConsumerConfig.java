package com.date.datingapp.infra.kafka;

import com.date.datingapp.adapter.kafka.event.UserCreatedEvent;
import com.date.datingapp.adapter.kafka.event.UserDeletedEvent;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
public class KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, UserCreatedEvent> userCreatedConsumerFactory(KafkaProperties kafkaProperties) {
        JsonDeserializer<UserCreatedEvent> deserializer = new JsonDeserializer<>(UserCreatedEvent.class);
        deserializer.addTrustedPackages("com.date.datingapp.adapter.kafka.event");

        return new DefaultKafkaConsumerFactory<>(
                kafkaProperties.buildConsumerProperties(),
                new StringDeserializer(),
                deserializer);
    }

    @Bean
    public ConsumerFactory<String, UserDeletedEvent> userDeletedConsumerFactory(KafkaProperties kafkaProperties) {
        JsonDeserializer<UserDeletedEvent> deserializer = new JsonDeserializer<>(UserDeletedEvent.class);
        deserializer.addTrustedPackages("com.date.datingapp.adapter.kafka.event");

        return new DefaultKafkaConsumerFactory<>(
                kafkaProperties.buildConsumerProperties(),
                new StringDeserializer(),
                deserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, UserCreatedEvent> userCreatedKafkaListenerContainerFactory(ConsumerFactory<String, UserCreatedEvent> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, UserCreatedEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, UserDeletedEvent> userDeletedKafkaListenerContainerFactory(ConsumerFactory<String, UserDeletedEvent> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, UserDeletedEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }
}
