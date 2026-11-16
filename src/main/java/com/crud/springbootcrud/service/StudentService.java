
package com.crud.springbootcrud.service;

import com.crud.springbootcrud.entity.Student;
import com.crud.springbootcrud.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    // Constructor Injection
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Create Service
    public Student create(Student studentReq) {
        return studentRepository.save(studentReq);
    }

    // Read Student By ID
    public Optional<Student> get(Long id) {
        return studentRepository.findById(id);
    }

    // Read All Service
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    // Update Service
    public Student update(Long id, Student studentRequest) {

        Student studentResponse = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));

        if (studentRequest.getName() != null) {
            studentResponse.setName(studentRequest.getName());
        }

        studentResponse.setRoll(studentRequest.getRoll());
        studentResponse.setEmail(studentRequest.getEmail());
        studentResponse.setAge(studentRequest.getAge());

        return studentRepository.save(studentResponse);
    }

    // Delete Service
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
