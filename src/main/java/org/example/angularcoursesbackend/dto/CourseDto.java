package org.example.angularcoursesbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDto {
    private String id;
    private String title;
    private String longDescription;
    private String iconUrl;
    private int lessonsCount;
    private String category;
    private int seqNo;
    private String url;
    private int price;
}
