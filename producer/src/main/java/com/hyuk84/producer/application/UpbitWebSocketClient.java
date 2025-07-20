package com.hyuk84.producer.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.hyuk84.producer.socket.UpbitWebSocketListener;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@Component
@RequiredArgsConstructor
public class UpbitWebSocketClient {

    private final OkHttpClient client = new OkHttpClient();

    private final UpbitWebSocketListener listener;

    @Value("${up-bit.websocket.url}")
    private String upBitWebsocketUrl;

    @PostConstruct
    public void start() {
        Request request = new Request.Builder().url(upBitWebsocketUrl).build();
        client.newWebSocket(request, listener);
    }
}
