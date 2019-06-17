package edu.mum.cs544.MumRegistrationApi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String name;
    @NotBlank
    private String code;
    @NotNull
    private CourseLevel level;

    @OneToMany
    private List<Course> prerequisiteCourses;

//    @JsonBackReference
    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<Section> sections;

//    @JsonBackReference
    @JsonIgnore
    @ManyToMany(mappedBy = "coursesCanTeach")
    private List<Faculty> facultiesCanTeach;
}