package edu.mum.cs544.MumRegistrationApi.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String country;
}
