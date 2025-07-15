package com.hyuk84.crypto.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.hyuk84.crypto.dto.TickerDto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KafkaMessageProducer {

    private final KafkaTemplate<String, TickerDto> kafkaTemplate;

    public void send(String topic, TickerDto message) {
        kafkaTemplate.send(topic, message);
    }
}
