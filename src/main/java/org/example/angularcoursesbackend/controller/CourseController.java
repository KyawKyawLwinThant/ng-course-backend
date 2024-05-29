package org.example.angularcoursesbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.angularcoursesbackend.dto.CourseDto;
import org.example.angularcoursesbackend.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public CourseDto getCourseById(@PathVariable("id") String id){
        return courseService.getCourseDtoById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/all")
    public CourseDto saveCourse(@RequestBody CourseDto courseDto){
        return courseService.createCourse(courseDto);
    }
    @PutMapping("/{id}")
    public CourseDto updateCourse(@RequestBody CourseDto courseDto, @PathVariable("id") String id){
        return courseService.updateCourse(id, courseDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCourseById(@PathVariable("id") String id){
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }


}
