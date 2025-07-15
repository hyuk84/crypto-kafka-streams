package com.hyuk84.crypto.socket;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyuk84.crypto.dto.TickerDto;
import com.hyuk84.crypto.kafka.KafkaMessageProducer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import okio.ByteString;

@Slf4j
@Component
@RequiredArgsConstructor
public class UpbitWebSocketListener extends WebSocketListener {

    private final KafkaMessageProducer producer;
    private final ObjectMapper objectMapper;

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        log.info("WebSocket connected: {}", response);
        String msg = "[{\"ticket\":\"test\"},{\"type\":\"ticker\",\"codes\":[\"KRW-BTC\"]}]";
        webSocket.send(msg);
    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        try {
            String json = bytes.utf8();
            log.info("Received message: {}", json);
            TickerDto tickerDto = objectMapper.readValue(json, TickerDto.class);
            producer.send("upbit-ticker", tickerDto);
        } catch (Exception e) {
            System.err.println("Failed to parse message: " + e.getMessage());
        }
    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        log.info("WebSocket closed: {} - {}", code, reason);
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        log.error("WebSocket connection failed: {}", t.getMessage());
    }

}
