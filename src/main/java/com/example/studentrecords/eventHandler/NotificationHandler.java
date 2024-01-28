package com.example.studentrecords.eventHandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(value = "app.listener.enabled")
@Component

public class NotificationHandler {
    @EventListener
    public void sendNotification(EventHandler eventHandler) {
        System.out.println(eventHandler.getEvent().text() + " " + eventHandler.getEvent().student());
    }
}
