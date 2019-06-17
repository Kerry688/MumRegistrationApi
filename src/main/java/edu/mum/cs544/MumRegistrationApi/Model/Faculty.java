package edu.mum.cs544.MumRegistrationApi.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class Faculty {

    private long id;
    private User user;
    private String firstName;
    private String lastName;
    private Gender gender;
    private int age;
    private String areaOfSpecilization;
    private Country country;
    private List<Course> coursesCanTeach;
    private List<Section> sections;
}