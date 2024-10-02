package com.hr.springbootwebflux.controller;

import com.hr.springbootwebflux.dto.School;
import com.hr.springbootwebflux.dto.Student;
import com.hr.springbootwebflux.dto.Teacher;
import com.hr.springbootwebflux.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return schoolService.getStudents();
    }

    @GetMapping("/teachers")
    public List<Teacher> getTeachers() {
        return schoolService.getTeachers();
    }

    @GetMapping("/all")
    public School getSchool() throws Exception {
        return schoolService.getSchoolDetails().get();
    }

}
