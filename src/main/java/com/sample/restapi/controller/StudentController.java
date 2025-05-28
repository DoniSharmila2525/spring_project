package com.sample.restapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {


    @PostMapping("/add")
    public String getAllStudents() {
        // Logic to retrieve all students
        return "Called Api"; // Placeholder response
    }

    @GetMapping(path = "/msg")
    public String msgToDoni(){
        return "Please change api logic ";
    }
}
