package org.example.angularcoursesbackend.service;

import lombok.RequiredArgsConstructor;
import org.example.angularcoursesbackend.dao.CourseDao;
import org.example.angularcoursesbackend.dto.CourseDto;
import org.example.angularcoursesbackend.util.DtoUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseDao courseDao;

    public List<CourseDto> listAllCourses(){
        return courseDao.findAll()
                .stream()
                .map(DtoUtil::toCourseDto)
                .collect(Collectors.toList());
    }
}
