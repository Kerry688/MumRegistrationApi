package edu.mum.cs544.MumRegistrationApi.Service;


import edu.mum.cs544.MumRegistrationApi.Model.Section;
import edu.mum.cs544.MumRegistrationApi.Model.Result;
import edu.mum.cs544.MumRegistrationApi.Model.Section;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SectionService {

    @Autowired
    private RestTemplate restTemplate;
    private String sectionURL ="http://localhost:8086/api/section";

    public List<Section> getSections(){

        ResponseEntity<List<Section>> response= restTemplate.exchange(sectionURL,
                HttpMethod.GET,null,new ParameterizedTypeReference<List<Section>>(){});
        return response.getBody();
    }

    public Section getSection(Long id) {
        return restTemplate.getForObject(sectionURL + "/" + id, Section.class);
    }

    public Result addSection(Section Section){

        URI uri=restTemplate.postForLocation(sectionURL,Section);
        if (uri == null) { return null; }
        Matcher m = Pattern.compile(".*/Section/(\\d+)").matcher(uri.getPath());
        m.matches();
        //return Long.parseLong(m.group(1));

       return new Result(true, "Section added!");
    }

    public Result updateSection(Section Section){
        restTemplate.put(sectionURL,Section,Section.getId());
        return new Result(true, "Section Updated!");
    }

    public Result deleteSection(long id){
        restTemplate.delete(sectionURL +"/"+id,id);
        return new Result(true, "Section deleted!");
    }


    // @Secured("ROLE_s")
    public List<Section> getAvailableSections(){

//        Iterable<Section> sections = sectionRepo.findAll();
//        List<SectionDto> sectionDtoList = new ArrayList<>();
//
//        for (Section section : sections) {
//            SectionDto sectionDto = new SectionDto();
//            sectionDto.setId(section.getId());
//            sectionDto.setBlock(section.getAssignedBlock().getName());
//            sectionDto.setCourseName(section.getCourse().getName());
//            sectionDto.setCourseCode(section.getCourse().getCode());
//            sectionDto.setSection(section.getSection().getFirstName());
//            sectionDto.setLocation(section.getLocation());
//            sectionDto.setCapacity(section.getCapacity());
//            sectionDto.setEnrolledSeats(section.getEnrolledStudents().size());
//            sectionDto.setAvailableSeats(section.getCapacity() - section.getEnrolledStudents().size());
//
//            sectionDtoList.add(sectionDto);
//        }
//        return sectionDtoList;
        return null;
    }

}
