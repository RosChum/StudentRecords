package com.example.studentrecords.mapper;

import com.example.studentrecords.model.Student;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StudentMapper {

    public Student convertToEntity(String firstName, String lastName, int age) {
        return Student.builder().id(UUID.randomUUID()).firstName(firstName).lastName(lastName).age(age).build();
    }


}
