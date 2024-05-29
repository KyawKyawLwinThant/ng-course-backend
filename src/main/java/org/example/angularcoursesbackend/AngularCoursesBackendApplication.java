package org.example.angularcoursesbackend;

import org.example.angularcoursesbackend.dao.CourseDao;
import org.example.angularcoursesbackend.dto.CourseDto;
import org.example.angularcoursesbackend.service.CourseService;
import org.example.angularcoursesbackend.util.DtoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;

@SpringBootApplication
public class AngularCoursesBackendApplication {
    private final RestClient restClient;
    private final CourseDao courseDao;
    private final CourseService courseService;
    private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    public AngularCoursesBackendApplication(CourseDao courseDao, CourseService courseService){
        this.courseDao = courseDao;
        this.courseService = courseService;
        restClient = RestClient.builder()
                .baseUrl("http://localhost:3000")
                .build();
    }



    @Bean @Profile("dev")
    public ApplicationRunner runner(){
        return r ->{
              //logger.info("Generated latest id code : %s".formatted(courseService.generateCourseId()));
//            List<CourseDto> courseDtoList = restClient.get()
//                    .uri("/courses")
//                    .retrieve()
//                    .body(new ParameterizedTypeReference<List<CourseDto>>() {});
//            courseDtoList.stream()
//                    .map(DtoUtil::toCourseEntity)
//                    .forEach(courseDao::save);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(AngularCoursesBackendApplication.class, args);
    }

}
