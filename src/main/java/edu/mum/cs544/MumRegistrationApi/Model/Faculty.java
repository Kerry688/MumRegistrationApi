package edu.mum.cs544.MumRegistrationApi.Model;

import lombok.Data;
import java.util.List;

@Data
public class Faculty {

    private long id;
    private User user;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String areaOfSpecilization;
    private String country;
    private List<Course> coursesCanTeach;
    private List<Section> sections;

}