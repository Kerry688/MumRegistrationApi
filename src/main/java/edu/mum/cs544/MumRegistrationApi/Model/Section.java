package edu.mum.cs544.MumRegistrationApi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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