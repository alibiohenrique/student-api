package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.request.StudentRequest;
import com.example.demo.model.response.StudentResponse;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public List<StudentResponse> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return studentMapper.toResponseList(students);
    }

    public StudentResponse getStudentById(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return studentMapper.toResponse(student);
    }

    public StudentResponse createStudent(StudentRequest studentRequest) {
        Student student = studentMapper.toEntity(studentRequest);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toResponse(savedStudent);
    }

    public StudentResponse updateStudent(StudentRequest studentRequest, Integer id) {
        Student student = studentRepository.findById(id).orElseThrow();

        student.setName(studentRequest.getName());
        student.setSurname(studentRequest.getSurname());
        student.setEmail(studentRequest.getEmail());
        student.setCpf(studentRequest.getCpf());
        student.setRg(studentRequest.getRg());

        Student updatedStudent = studentRepository.save(student);
        return studentMapper.toResponse(updatedStudent);
    }

    public StudentResponse patchStudent(StudentRequest studentRequest, Integer id) {
        Student student = studentRepository.findById(id).orElseThrow();

        if (studentRequest.getName() != null) student.setName(studentRequest.getName());
        if (studentRequest.getSurname() != null) student.setSurname(studentRequest.getSurname());
        if (studentRequest.getEmail() != null) student.setEmail(studentRequest.getEmail());
        if (studentRequest.getCpf() != null) student.setCpf(studentRequest.getCpf());
        if (studentRequest.getRg() != null) student.setRg(studentRequest.getRg());

        Student patchedStudent = studentRepository.save(student);
        return studentMapper.toResponse(patchedStudent);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
