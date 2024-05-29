package org.example.angularcoursesbackend.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.angularcoursesbackend.dao.CourseDao;
import org.example.angularcoursesbackend.dto.CourseDto;
import org.example.angularcoursesbackend.entity.Course;
import org.example.angularcoursesbackend.util.DtoUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseDao courseDao;

    public CourseDto getCourseDtoById(String id){
        return courseDao.findById(id)
                .map(DtoUtil::toCourseDto)
                .orElseThrow(EntityNotFoundException::new);
    }

    public CourseDto createCourse(CourseDto courseDto) {
        courseDto.setId(generateCourseId());
        return DtoUtil.toCourseDto(courseDao.save(DtoUtil.toCourseEntity(courseDto)));
    }
    public CourseDto updateCourse(String id,CourseDto courseDto) {
        if(courseDao.existsById(id)){
            courseDto.setId(id);
            return DtoUtil.toCourseDto(courseDao.save(DtoUtil.toCourseEntity(courseDto)));
        }
        else
            throw new EntityNotFoundException(id + " not found");
    }

    public void deleteCourse(String id) {
        courseDao.deleteById(id);
    }

    private String generateCourseId() {
        int sid=courseDao.findAll()
                .stream()
                .map(Course::getId)
                .map( id -> Integer.parseInt(id))
                .mapToInt(Integer::intValue)
                .max().getAsInt();
        System.out.println("sid:"+ sid);
        return String.valueOf( sid + 1);
    }

    public List<CourseDto> listAllCourses(){
        return courseDao.findAll()
                .stream()
                .map(DtoUtil::toCourseDto)
                .collect(Collectors.toList());
    }
}
