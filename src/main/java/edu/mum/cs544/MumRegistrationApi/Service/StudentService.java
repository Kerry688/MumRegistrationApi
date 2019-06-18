package edu.mum.cs544.MumRegistrationApi.Service;


import edu.mum.cs544.MumRegistrationApi.Model.Result;
import edu.mum.cs544.MumRegistrationApi.Model.Section;
import edu.mum.cs544.MumRegistrationApi.Model.Student;
import edu.mum.cs544.MumRegistrationApi.dto.SectionDto;
import edu.mum.cs544.MumRegistrationApi.dto.StudentDto;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class StudentService   {

    private String studentURL = "http://localhost:8083/api/student";

    @Autowired
    private RestTemplate restTemplate;


   // @Secured("ROLE_a")
    public List<Student> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Student>> response = restTemplate.exchange(studentURL, HttpMethod.GET,null,new ParameterizedTypeReference<List<Student>>(){});
        List<Student> students = response.getBody();
        return students;
    }

    public Student get(long id){
        return  restTemplate.getForObject(studentURL+"/"+ id,  Student.class);
    }


   // @Secured("ROLE_a")
    public Result add(Student student) {
        URI uri=restTemplate.postForLocation(studentURL,student);
        return new Result(true, "Student added!");
    }

    //@Secured("ROLE_a")
    public Result update(Student student) {
        restTemplate.put(studentURL,student,student.getId());
        return new Result(true, "Student updated!");
    }

    //@Secured("ROLE_a")
    public Result delete(long id) {
        restTemplate.delete(studentURL +"/" +id,id);
        return new Result(true, "Student deleted!");
    }


//    //@Secured("ROLE_s")
     public List<Section> getEnrolledSections(long userId) {
//        Student student = getStudentByUserId(userId);
//        List<SectionDto> sectionDtoList = new ArrayList<>();
//
//        List<Section> sections = student.getSections();
//        for (Section section : sections) {
//            SectionDto sectionDto = new SectionDto();
//            sectionDto.setId(section.getId());
//            sectionDto.setCourseName(section.getCourse().getName());
//            sectionDto.setCourseCode(section.getCourse().getCode());
//            sectionDto.setBlock(section.getAssignedBlock().getName());
//            sectionDto.setFaculty(section.getFaculty().getFirstName() + " " + section.getFaculty().getLastName());
//            sectionDtoList.add(sectionDto);
//        }
//        return sectionDtoList;

         return null;
    }

  //  @Secured("ROLE_s")
    public Result registerForSections(long userId, int[] sectionIdArray) {
//        Student student = getStudentByUserId(userId);
//        List<Section> sections = new ArrayList<>();
//
//        for (int sectionId : sectionIdArray) {
//            Section section = sectionRepo.getSectionById(sectionId);
//            if (section.getCapacity() == section.getEnrolledStudents().size())
//                return new Result(false, section.getCourse().getName() + " - " + section.getFaculty().getFirstName() + " " + section.getFaculty().getLastName() + " section has no available seats!");
//            sections.add(section);
//        }
//        student.setSections(sections);
//        studentRepo.save(student);

        return new Result(true, "Registered for these sections!");
    }
}
