package com.example.demo.mapper;

import com.example.demo.entity.Student;
import com.example.demo.model.request.StudentRequest;
import com.example.demo.model.response.StudentResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentMapper {
    public StudentResponse toResponse(Student student) {
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setFullName(student.getName() + " " + student.getSurname());
        response.setEmail(student.getEmail());
        return response;
    }

    public Student toEntity(StudentRequest request) {
        Student student = new Student();
        student.setName(request.getName());
        student.setSurname(request.getSurname());
        student.setEmail(request.getEmail());
        student.setCpf(request.getCpf());
        student.setRg(request.getRg());
        return student;
    }

    public List<StudentResponse> toResponseList(List<Student> students) {
        return students.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

}
