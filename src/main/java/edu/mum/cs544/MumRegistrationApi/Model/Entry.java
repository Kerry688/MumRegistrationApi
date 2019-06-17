package edu.mum.cs544.MumRegistrationApi.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Data
public class Entry {
    private long id;
    private LocalDate entryStartDate;
    private List<Student> students;
}
