package edu.mum.cs544.MumRegistrationApi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
public class Faculty {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

//    @JsonBackReference
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private User user;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    private Gender gender;
    @NotNull
    private int age;
    private String areaOfSpecilization;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

//    @JsonManagedReference
    @JsonIgnore
    @ManyToMany
    private List<Course> coursesCanTeach;

//    @JsonBackReference
    @JsonIgnore
    @OneToMany(mappedBy = "faculty", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Section> sections;
}