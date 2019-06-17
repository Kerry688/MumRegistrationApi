package edu.mum.cs544.MumRegistrationApi.Model;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class Course {
    private long id;
    private String name;
    private String code;
    private CourseLevel level;
    private List<Course> prerequisiteCourses;
    private List<Section> sections;
    private List<Faculty> facultiesCanTeach;
}