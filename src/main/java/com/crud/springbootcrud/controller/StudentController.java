
package com.crud.springbootcrud.controller;

import com.crud.springbootcrud.entity.Student;
import com.crud.springbootcrud.service.StudentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    // Constructor Injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Create API
    @PostMapping("/create")
    public ResponseEntity<Student> create(@RequestBody Student studentRequest) {
        Student savedStudent = studentService.create(studentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    // Read By ID
    @GetMapping("/get/{id}")
    public Optional<Student> getById(@PathVariable Long id) {
        return studentService.get(id);
    }

    // Read All API
    @GetMapping("/getAll")
    public List<Student> getAll() {
        return studentService.getAll();
    }

    // Update API
    @PutMapping("/update/{id}")
    public Student update(@PathVariable Long id,
                          @RequestBody Student studentRequest) {
        return studentService.update(id, studentRequest);
    }

    // Delete API
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        studentService.delete(id);
        return "User deleted successfully! " + id;
    }
}
