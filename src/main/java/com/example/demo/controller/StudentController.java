package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")

@CrossOrigin("http://localhost:80")
public class StudentController {
    private final StudentRepo repo;
    StudentController(StudentRepo studentRepo){
        this.repo=studentRepo;
    }

    @GetMapping
    public List<Student> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return repo.save(student);
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable ObjectId id) {
        return repo.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable ObjectId id, @RequestBody Student student) {
        student.setId(id);
        return repo.save(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ObjectId id) {
        repo.deleteById(id);
    }
}
