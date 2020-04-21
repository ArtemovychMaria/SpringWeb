package com.example.SpringWeb.FileUpload.controlers;

import com.example.SpringWeb.FileUpload.dto.StudentRequest;
import com.example.SpringWeb.FileUpload.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/")
    public String newStudent(HttpServletRequest req) {
        return "studentRegistr";
    }

    @PostMapping("/registr")
    public String create(@ModelAttribute StudentRequest studentRequest, HttpServletRequest req) {
        int studentId=studentService.create(studentRequest);
        req.setAttribute("student",studentService.readById(studentId).get());
        return "cabinet";
    }
}
