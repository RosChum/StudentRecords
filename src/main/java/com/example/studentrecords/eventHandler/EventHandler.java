package com.example.studentrecords.eventHandler;

import com.example.studentrecords.model.Student;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class EventHandler extends ApplicationEvent {

   private Event event;

    public EventHandler(Object source, Event event) {
        super(source);
        this.event = event;
    }
}
