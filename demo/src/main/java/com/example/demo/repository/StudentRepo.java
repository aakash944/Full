package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student, ObjectId> {
}
