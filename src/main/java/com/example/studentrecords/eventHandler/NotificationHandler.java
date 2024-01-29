package com.example.studentrecords.eventHandler;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
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
