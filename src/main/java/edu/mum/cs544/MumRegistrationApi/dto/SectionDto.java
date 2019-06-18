package edu.mum.cs544.MumRegistrationApi.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SectionDto {

    private Long id;
    private String courseName;
    private String courseCode;
    private String faculty;
    private int capacity;
    private int enrolledSeats;
    private int availableSeats;
    private String location;
    private String block;


}
