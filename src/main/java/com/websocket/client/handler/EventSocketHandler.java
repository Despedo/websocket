package com.websocket.client.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class EventSocketHandler extends TextWebSocketHandler implements WebSocketHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventSocketHandler.class);
    private static final String SEPARATOR = "----------------------------------------------------------------------";

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        LOGGER.info(SEPARATOR);
        LOGGER.info("Client received: {}", message.getPayload());
        LOGGER.info(SEPARATOR);
    }

}
