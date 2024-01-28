package com.example.studentrecords;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class StudentRecordsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentRecordsApplication.class, args);
	}

}
