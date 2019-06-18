package edu.mum.cs544.MumRegistrationApi.Model;


import lombok.Data;
import java.util.List;

@Data
public class Section {
    private long id;
    private String location;
    private int capacity;
    private Block assignedBlock;
    private Faculty faculty;
    private Course course;
    private List<Student> enrolledStudents;
}