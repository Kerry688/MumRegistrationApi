package edu.mum.cs544.MumRegistrationApi.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class Student {
    private long id;
    private User user;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String country;
    private boolean isMPP;
    private String studentType;
    private Entry entry;
    private List<Section> sections;

}