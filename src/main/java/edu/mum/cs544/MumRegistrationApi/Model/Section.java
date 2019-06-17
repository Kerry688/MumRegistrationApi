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

public class Section {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @NotBlank
    private String location;
    @NotNull
    private int capacity;

//    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="block_id")
    private Block assignedBlock;

//    @JsonManagedReference
    @ManyToOne()
    @JoinColumn(name="faculty_id")
    private Faculty faculty;

//    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

//    @JsonBackReference
    @JsonIgnore
    @ManyToMany(mappedBy = "sections")
//    @Fetch(value = FetchMode.SUBSELECT)
    private List<Student> enrolledStudents;
}