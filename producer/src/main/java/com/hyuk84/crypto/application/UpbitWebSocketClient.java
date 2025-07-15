package com.hyuk84.crypto.application;

import org.springframework.stereotype.Component;

import com.hyuk84.crypto.socket.UpbitWebSocketListener;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@Component
@RequiredArgsConstructor
public class UpbitWebSocketClient {

    private final OkHttpClient client = new OkHttpClient();

    private final UpbitWebSocketListener listener;

    @PostConstruct
    public void start() {
        Request request = new Request.Builder().url("wss://api.upbit.com/websocket/v1").build();
        client.newWebSocket(request, listener);
    }
}
