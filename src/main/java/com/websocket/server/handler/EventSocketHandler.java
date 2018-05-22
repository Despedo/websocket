package com.websocket.server.handler;

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
    public void afterConnectionEstablished(WebSocketSession session) {
        LOGGER.info(SEPARATOR);
        LOGGER.info("Server Socket Connected: {}", session);
        LOGGER.info(SEPARATOR);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        session.sendMessage(new TextMessage("Response from the server"));
        LOGGER.info(SEPARATOR);
        LOGGER.info("Server received: {}", message.getPayload());
        LOGGER.info(SEPARATOR);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) {
        LOGGER.info(SEPARATOR);
        LOGGER.info("Server Socket Closed: code-[{}] reason-[{}]", closeStatus.getCode(), closeStatus.getReason());
        LOGGER.info(SEPARATOR);
    }
}
