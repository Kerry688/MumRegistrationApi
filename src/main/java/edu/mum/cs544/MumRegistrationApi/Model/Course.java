package edu.mum.cs544.MumRegistrationApi.Model;
import lombok.Data;

import java.util.List;

@Data
public class Course {
    private long id;
    private String name;
    private String code;
    private String level;
    private List<Course> prerequisiteCourses;
    private List<Section> sections;
    private List<Faculty> facultiesCanTeach;
}