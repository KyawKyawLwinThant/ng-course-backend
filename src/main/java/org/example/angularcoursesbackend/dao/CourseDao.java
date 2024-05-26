package org.example.angularcoursesbackend.dao;

import org.example.angularcoursesbackend.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course,String> {
}
