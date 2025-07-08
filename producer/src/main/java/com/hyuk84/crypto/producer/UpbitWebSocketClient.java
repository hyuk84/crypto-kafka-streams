package com.hyuk84.crypto.producer;

import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import okhttp3.*;
import okio.ByteString;

@Component
public class UpbitWebSocketClient {

    private final OkHttpClient client = new OkHttpClient();

    @PostConstruct
    public void init() {
        Request request = new Request.Builder()
            .url("wss://api.upbit.com/websocket/v1")
            .build();

        client.newWebSocket(request, new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, Response response) {
                System.out.println("WebSocket Opened");
                String msg = "[{\"ticket\":\"test\"},{\"type\":\"ticker\",\"codes\":[\"KRW-BTC\"]}]";
                webSocket.send(msg);
            }

            @Override
            public void onMessage(WebSocket webSocket, ByteString bytes) {
                String decoded = bytes.string(StandardCharsets.UTF_8);
                System.out.println("WebSocket binary message: " + decoded);
            }

            @Override
            public void onMessage(WebSocket webSocket, String text) {
                System.out.println("WebSocket message: " + text);
            }

            @Override
            public void onClosing(WebSocket webSocket, int code, String reason) {
                System.out.println("WebSocket closing: " + code + " " + reason);
            }

            @Override
            public void onFailure(WebSocket webSocket, Throwable t, Response response) {
                System.out.println("WebSocket failure: " + t.getMessage());
            }
        });
    }

}
