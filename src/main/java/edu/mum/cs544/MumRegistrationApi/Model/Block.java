package edu.mum.cs544.MumRegistrationApi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String name;

    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;

//    @JsonBackReference
    @JsonIgnore
    @OneToMany (mappedBy = "assignedBlock")
    private List<Section> sections;
}
