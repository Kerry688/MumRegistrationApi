package edu.mum.cs544.MumRegistrationApi.Model;
import lombok.Data;

@Data
public class User {
    private long id;
    private String username;
    private String password;
    private Roles role;


//    private Student student;
//    private Faculty faculty;

}
