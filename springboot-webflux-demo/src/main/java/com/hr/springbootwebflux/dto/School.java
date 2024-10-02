package com.hr.springbootwebflux.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {
    private List<Student> students;
    private List<Teacher> teachers;
}
