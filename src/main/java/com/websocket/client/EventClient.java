package com.websocket.client;
import com.websocket.client.handler.EventSocketHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

public class EventClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventClient.class);
    private static final String URI = "ws://localhost:8090/events";

    public static void main(String[] args) {
        StandardWebSocketClient client = new StandardWebSocketClient();

        EventSocketHandler socket = new EventSocketHandler(){};
        ListenableFuture<WebSocketSession> fut = client.doHandshake(socket, URI);

        try (WebSocketSession session = fut.get()) {
            session.sendMessage(new TextMessage("Hello"));
            Thread.sleep(10);
            session.close(new CloseStatus(1000, "Test reason"));
        } catch (Exception e) {
            LOGGER.error("WebSocketSession error:", e);
        }
    }
}
