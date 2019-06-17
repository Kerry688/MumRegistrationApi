package edu.mum.cs544.MumRegistrationApi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String password;

//    @JsonManagedReference
    @JsonIgnore
    @OneToOne(mappedBy = "user")
    //@JoinColumn
    private Student student;

//    @JsonManagedReference
    @JsonIgnore
    @OneToOne(mappedBy = "user")
   // @JoinColumn
    private Faculty faculty;

    @ManyToOne
    @JoinColumn
    private Roles role;


}
