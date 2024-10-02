package com.hr.springbootwebflux.service;

import com.hr.springbootwebflux.dto.School;
import com.hr.springbootwebflux.dto.Student;
import com.hr.springbootwebflux.dto.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class SchoolService {
    @Autowired
    private WebClient webClient;

    public List<Student> getStudents() {
        return List.of(
                new Student(1, "John"),
                new Student(2, "Matt"),
                new Student(3, "Raj")
        );
    }

    public List<Teacher> getTeachers() {
        return List.of(
                new Teacher("Phil", "Math"),
                new Teacher("Alex", "Science"),
                new Teacher("Jacob", "English")
        );
    }

    public CompletableFuture<School> getSchoolDetails() {
        final Flux<Student> studentsFlux = webClient.get()
                .uri("http://localhost:9091/school/students")
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Student>() {
                });

        final Flux<Teacher> teachersFlux = webClient.get()
                .uri("http://localhost:9091/school/teachers")
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Teacher>() {
                });

        // The response of two REST api calls are combined and returned in the response
        return studentsFlux
                .collectList()
                .zipWith(teachersFlux.collectList(), (students, teachers) -> new School(students, teachers))
                .subscribeOn(Schedulers.boundedElastic()) // To offload the blocking operation to a different thread
                .toFuture();
    }
}
