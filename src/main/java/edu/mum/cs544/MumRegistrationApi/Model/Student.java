package edu.mum.cs544.MumRegistrationApi.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

//    @JsonBackReference
    @OneToOne
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

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @NotNull
    private boolean isMPP;
    @NotNull
    private StudentType studentType;

    @ManyToOne
    @JoinColumn(name = "entry_id")
    private Entry entry;

//    @JsonManagedReference
    @ManyToMany
    private List<Section> sections;
}