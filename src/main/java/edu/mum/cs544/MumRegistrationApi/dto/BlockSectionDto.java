package edu.mum.cs544.MumRegistrationApi.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class BlockSectionDto {

    private long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    private List<SectionDto> sectionDto;
}
