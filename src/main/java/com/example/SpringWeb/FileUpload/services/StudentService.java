package com.example.SpringWeb.FileUpload.services;

import com.example.SpringWeb.FileUpload.dto.StudentRequest;
import com.example.SpringWeb.FileUpload.entities.Student;
import com.example.SpringWeb.FileUpload.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public int create(StudentRequest studentRequest){
        Student student = new Student(studentRequest.getFirstName(),
                studentRequest.getLastName(),Integer.parseInt(studentRequest.getAge()));
        String photoId = studentRequest.getPhotoId();
        if(!photoId.isEmpty()) {
            student.setPhotoId(photoId);
        }
        studentRepository.save(student);
        return student.getId();
    }

    public Optional<Student> readById(int id){
        return studentRepository.findById(id);
    }

    public List<Student> readAll() {
        return studentRepository.findAll();
    }

}
