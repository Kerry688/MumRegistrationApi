package edu.mum.cs544.MumRegistrationApi.Model;

import lombok.Data;

@Data
public class Admission {
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
}
