package com.example.studentrecords.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class Student {
    private UUID id;
    private String firstName;
    private String lastName;
    private int age;

    @Override
    public String toString() {
        return
                "id = " + id +
                        ", firstName = " + firstName +
                        ", lastName = " + lastName +
                        ", age=" + age;
    }
}
