package edu.mum.cs544.MumRegistrationApi.Service;

import edu.mum.cs544.MumRegistrationApi.Model.Course;
import edu.mum.cs544.MumRegistrationApi.Model.Faculty;
import edu.mum.cs544.MumRegistrationApi.Model.Result;
import edu.mum.cs544.MumRegistrationApi.Model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class FacultyService  {

    @Autowired
    private RestTemplate restTemplate;

    private String facultyURL ="http://localhost:8084/api/faculty";

    public List<Faculty> getFaculties(){

        ResponseEntity<List<Faculty>> response= restTemplate.exchange(facultyURL,
                HttpMethod.GET,null,new ParameterizedTypeReference<List<Faculty>>(){});
        return response.getBody();
    }

    public Faculty getFaculty(Long id) {
        return restTemplate.getForObject(facultyURL + "/" + id, Faculty.class);
    }

    public Long addFaculty(Faculty faculty){

        URI uri=restTemplate.postForLocation(facultyURL,faculty);
        if (uri == null) { return null; }
        Matcher m = Pattern.compile(".*/faculty/(\\d+)").matcher(uri.getPath());
        m.matches();
        return Long.parseLong(m.group(1));

        //return new Result(true, "Faculty added!");
    }

    public void updateFaculty(Faculty faculty){
        restTemplate.put(facultyURL,faculty,faculty.getId());
    }

    public Result deleteFaculty(long id){
        restTemplate.delete(facultyURL +"/"+id,id);
        return new Result(true, "Course deleted!");
    }


    public List<Course> getCoursesCanTeach(long UserId){

//        Faculty faculty = getFacultyByUserId(userId);
//        List<Course> courseList = faculty.getCoursesCanTeach();
//
//        List<CourseDto> courseDtoList = new ArrayList<>();
//        for(Course course : courseList){
//            CourseDto courseDto = new CourseDto();
//            courseDto.setId(course.getId());
//            courseDto.setCode(course.getCode());
//            courseDto.setLevel(course.getLevel().name());
//            courseDto.setName(course.getName());
//            courseDtoList.add(courseDto);
//        }
//        return courseDtoList;

        return null;
    }

    public Result addCourseCanTeach(long courseId, long userId)
    {

//        Faculty faculty = getFacultyByUserId(userId);
//        Course course = courseRepo.findById(courseId).get();
//
//        boolean same = faculty.getCoursesCanTeach().stream().anyMatch(c -> c.getId() == courseId);
//
//        if(same)
//            return new Result(false, course.getName() + " course can not add again!");
//
//        faculty.getCoursesCanTeach().add(course);
//        facultyRepo.save(faculty);
//        return new Result(true, "Course added for faculty!");

        return  null;
    }


    public Result deleteCourseCanTeach(long courseId, long userId){

//        Course course = courseRepo.findById(courseId).get();
//        Faculty faculty = getFacultyByUserId(userId) ;
//
//        faculty.getCoursesCanTeach().remove(course);
//        facultyRepo.save(faculty);
        return new Result(true, "Course removed from faculty's list.");
    }

    public List<Section> getEnrolledSections(long userId) {
//        Faculty faculty = getFacultyByUserId(userId);
//        List<SectionDto> sectionDtoList = new ArrayList<>();
//
//        List<Section> sections = faculty.getSections();
//        for (Section section : sections) {
//            SectionDto sectionDto = new SectionDto();
//            sectionDto.setId(section.getId());
//            sectionDto.setCourseName(section.getCourse().getName());
//            sectionDto.setCourseCode(section.getCourse().getCode());
//            sectionDto.setBlock(section.getAssignedBlock().getName());
//            sectionDto.setCapacity(section.getCapacity());
//            sectionDtoList.add(sectionDto);
//        }
//        return sectionDtoList;
        return null;
    }


}
