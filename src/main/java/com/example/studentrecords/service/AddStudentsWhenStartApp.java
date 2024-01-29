package com.example.studentrecords.service;

import com.example.studentrecords.mapper.StudentMapper;
import com.example.studentrecords.storage.StudentStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty("app.init-students")

public class AddStudentsWhenStartApp {

    private final StudentStorage studentStorage;
    private final StudentMapper studentMapper;

    @EventListener(ApplicationReadyEvent.class)
    protected void addStudent() {

        System.out.println(" addStudent addStudent addStudent ");
        Thread thread = new Thread(() -> {
            studentStorage.add(studentMapper.convertToEntity("Ivan", "Petrov", 21));
            studentStorage.add(studentMapper.convertToEntity("Алексей", "Сергеев", 30));
            studentStorage.add(studentMapper.convertToEntity("Рулон", "Обоев", 18));
            studentStorage.add(studentMapper.convertToEntity("Учет", "Расходов", 19));
            studentStorage.add(studentMapper.convertToEntity("Букет", "Тюльпанов", 23));
        });
        thread.start();
    }

}
