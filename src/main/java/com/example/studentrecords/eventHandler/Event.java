package com.example.studentrecords.eventHandler;

import com.example.studentrecords.model.Student;
import lombok.Data;


public record Event(String text, Student student) {

}
