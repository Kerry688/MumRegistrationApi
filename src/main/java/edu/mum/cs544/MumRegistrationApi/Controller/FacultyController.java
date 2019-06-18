package edu.mum.cs544.MumRegistrationApi.Controller;


import edu.mum.cs544.MumRegistrationApi.Model.Course;
import edu.mum.cs544.MumRegistrationApi.Model.Faculty;
import edu.mum.cs544.MumRegistrationApi.Model.Result;
import edu.mum.cs544.MumRegistrationApi.Model.Section;
import edu.mum.cs544.MumRegistrationApi.Service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api/faculty")

public class FacultyController {

    @Autowired
    private FacultyService service;

    @GetMapping()
    public List<Faculty> getFaculties() {
        return service.getFaculties();
    }

    @GetMapping(path = "/{id}")
    public Faculty getFacultyById(@PathVariable long id){
        return service.getFaculty(id);
    }


    @PostMapping()
    public void addFaculty(@RequestBody Faculty faculty){
         service.addFaculty(faculty);
    }

    @PutMapping()
    public void updateFaculty(@RequestBody Faculty faculty){
         service.updateFaculty(faculty);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteFaculty(@PathVariable long id){
         service.deleteFaculty(id);
    }


    @PostMapping(path = "/addcourse/{courseId}")
    public Result addCourseCanTeach(@PathVariable long courseId, @RequestBody long userId){
        return service.addCourseCanTeach(courseId, userId);
    }

    @GetMapping(path = "/coursescanteach/{userId}")
    public List<Course> getCoursesCanTeach(@PathVariable long userId){
        return service.getCoursesCanTeach(userId);
    }

    @PutMapping(path = "/coursescanteach/{courseId}")
    public Result deleteCourseCanTeach(@PathVariable long courseId, @RequestBody long userId){
        return service.deleteCourseCanTeach(courseId, userId);
    }

    @GetMapping(path = "/enrolledsections/{userId}")
    public List<Section> getEnrolledSections(@PathVariable long userId){
        return service.getEnrolledSections(userId);
    }
}
