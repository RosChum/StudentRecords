package com.example.studentrecords.storage;

import com.example.studentrecords.model.Student;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StudentStorage {

    private final Map<UUID, Student> storage = new HashMap<>();

    public boolean add(Student student) {
        if (!storage.containsValue(student)) {
            storage.put(student.getId(), student);
            return true;
        } else {
            return false;
        }

    }

    public boolean delete(UUID uuid) {
        if (storage.containsKey(uuid)) {
            storage.remove(uuid);
            return true;
        } else {
            return false;
        }

    }

    public String getAll() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Student> studentIterator = storage.values().iterator();
        while (studentIterator.hasNext()){
            stringBuilder.append(studentIterator.next()).append("\n");
        }

        return stringBuilder.toString();
    }

    public void deleteAll() {
        storage.clear();
    }
}
