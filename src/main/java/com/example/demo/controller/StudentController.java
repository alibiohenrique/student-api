package com.example.demo.controller;

import com.example.demo.model.request.StudentRequest;
import com.example.demo.model.response.StudentResponse;
import com.example.demo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAllStudents() {
        List<StudentResponse> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable Integer id) {
        StudentResponse student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentRequest studentRequest) {
        StudentResponse student = studentService.createStudent(studentRequest);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> updateStudent(@PathVariable Integer id, @RequestBody StudentRequest studentRequest) {
        StudentResponse updatedStudent = studentService.updateStudent(studentRequest, id);
        return ResponseEntity.ok(updatedStudent);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentResponse> patchStudent(@PathVariable Integer id, @RequestBody StudentRequest studentRequest) {
        StudentResponse patchedStudent = studentService.patchStudent(studentRequest, id);
        return ResponseEntity.ok(patchedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
