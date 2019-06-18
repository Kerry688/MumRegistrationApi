package edu.mum.cs544.MumRegistrationApi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDto {

    private long id;
    private String name;
    private String code;
    private String level;

}
