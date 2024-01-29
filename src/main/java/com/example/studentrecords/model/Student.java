package com.example.studentrecords.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        if (this.id.equals(student.id)) return true;
        return age == student.age && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return
                "id = " + id +
                        ", firstName = " + firstName +
                        ", lastName = " + lastName +
                        ", age=" + age;
    }
}
