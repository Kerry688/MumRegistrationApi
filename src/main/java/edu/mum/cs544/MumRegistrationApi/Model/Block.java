package edu.mum.cs544.MumRegistrationApi.Model;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Data
public class Block {
    private long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Section> sections;
}
