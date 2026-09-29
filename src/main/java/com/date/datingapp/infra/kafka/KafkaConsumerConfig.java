package com.date.datingapp.infra.kafka;

import com.date.datingapp.adapter.kafka.event.UserCreatedEvent;
import com.date.datingapp.adapter.kafka.event.UserDeletedEvent;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.util.backoff.FixedBackOff;

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
    public DefaultErrorHandler kafkaErrorHandler() {
        return new DefaultErrorHandler(new FixedBackOff(5000L, 3));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, UserCreatedEvent> userCreatedKafkaListenerContainerFactory(@Qualifier("userCreatedConsumerFactory") ConsumerFactory<String, UserCreatedEvent> consumerFactory,
                                                                                                                      DefaultErrorHandler errorHandler) {
        ConcurrentKafkaListenerContainerFactory<String, UserCreatedEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.setCommonErrorHandler(errorHandler);
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, UserDeletedEvent> userDeletedKafkaListenerContainerFactory(@Qualifier("userDeletedConsumerFactory") ConsumerFactory<String, UserDeletedEvent> consumerFactory,
                                                                                                                      DefaultErrorHandler errorHandler) {
        ConcurrentKafkaListenerContainerFactory<String, UserDeletedEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.setCommonErrorHandler(errorHandler);
        return factory;
    }
}
