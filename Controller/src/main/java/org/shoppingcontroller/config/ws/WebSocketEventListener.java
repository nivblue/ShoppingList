package org.shoppingcontroller.config.ws;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
//import org.todows.ChatMessage;

import java.util.Objects;

@Log4j2
@Component
@RequiredArgsConstructor
public class WebSocketEventListener {
    @Autowired
    private final SimpMessageSendingOperations messageTemplate;

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");

        if (Objects.nonNull(username)) {
            log.info("User disconnected : {}", username);
//            ChatMessage chatMessage = ChatMessage.builder()
//                    .messageType(ChatMessage.MessageType.LEAVE)
//                    .sender(username)
//                    .build();
//
//            messageTemplate.convertAndSend("/topic/public", chatMessage);
        }
    }
}
