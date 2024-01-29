package com.example.studentrecords.service;

import com.example.studentrecords.eventHandler.Event;
import com.example.studentrecords.eventHandler.EventHandler;
import com.example.studentrecords.mapper.StudentMapper;
import com.example.studentrecords.storage.StudentStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.UUID;

@ShellComponent
@RequiredArgsConstructor
public class ConsoleService {


    private final StudentStorage studentStorage;
    private final StudentMapper studentMapper;
    private final ApplicationEventPublisher publisher;


    //add --f Andry --l Bobrov --a 29
    @ShellMethod(key = "add")
    public void addStudent(@ShellOption(value = "f") String firstName, @ShellOption(value = "l") String lastName, @ShellOption(value = "a") int age) {
        if (studentStorage.add(studentMapper.convertToEntity(firstName, lastName, age))) {
            publisher.publishEvent(new EventHandler(this, new Event("Добавлен новый студент"
                    , "Имя: " + firstName + " Фамилия: " + lastName + " Возраст: " + age)));
        } else {
            publisher.publishEvent(new EventHandler(this, new Event("Студент с таким ФИО и датой рождения уже имеется"
                    , "")));
        }
    }

    @ShellMethod(key = "del")
    public void deleteStudent(@ShellOption(value = "u") String uuid) {
        if (studentStorage.delete(UUID.fromString(uuid))) {
            publisher.publishEvent(new EventHandler(this, new Event("Студент c Id " + uuid + " удален"
                    , "")));
        } else {
            publisher.publishEvent(new EventHandler(this, new Event("Студент c Id " + uuid + " не найден"
                    , "")));
        }
    }

    @ShellMethod(key = "get")
    public String getAll() {
        return studentStorage.getAll().toString();
    }


    @ShellMethod(key = "delAll")
    public void delAll() {
        studentStorage.deleteAll();
    }
}
