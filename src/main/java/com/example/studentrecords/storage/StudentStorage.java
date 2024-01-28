package com.example.studentrecords.storage;

import com.example.studentrecords.model.Student;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class StudentStorage {

    private final Map<UUID, Student> storage = new HashMap<>();

    public Student add(Student student) {
        return storage.put(student.getId(), student);
    }

    public Student delete(UUID uuid) {
        return storage.remove(uuid);
    }

    public List<Student> getAll() {
        return storage.values().stream().toList();
    }

    public void deleteAll() {
        storage.clear();
    }
}
