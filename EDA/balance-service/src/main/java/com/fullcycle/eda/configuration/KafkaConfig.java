package com.fullcycle.eda.configuration;

import com.fullcycle.eda.dto.TransactionEventDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

@Configuration
@EnableKafka
public class KafkaConfig {


    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, TransactionEventDTO>
    kafkaListenerContainerFactory(ConsumerFactory<String, TransactionEventDTO> cf) {
        ConcurrentKafkaListenerContainerFactory<String, TransactionEventDTO> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(cf);
        factory.getContainerProperties().setPollTimeout(3000);
        return factory;
    }
}