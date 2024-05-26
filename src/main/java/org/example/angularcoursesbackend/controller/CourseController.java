package org.example.angularcoursesbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.angularcoursesbackend.dto.CourseDto;
import org.example.angularcoursesbackend.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
@CrossOrigin()
public class CourseController {
    private final CourseService courseService;
    @GetMapping("/all")
    public List<CourseDto> listAllCourses(){
        return courseService.listAllCourses();
    }
}
