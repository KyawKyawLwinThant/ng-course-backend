package org.example.angularcoursesbackend.util;

import org.example.angularcoursesbackend.entity.Course;
import org.example.angularcoursesbackend.dto.CourseDto;
import org.springframework.beans.BeanUtils;

public class DtoUtil {
    public static CourseDto toCourseDto(Course course){
        CourseDto courseDto=new CourseDto();
        BeanUtils.copyProperties(course,courseDto);
        return courseDto;
    }
    public static Course toCourseEntity(CourseDto courseDto){
        Course course=new Course();
        BeanUtils.copyProperties(courseDto,course);
        return course;
    }
}
