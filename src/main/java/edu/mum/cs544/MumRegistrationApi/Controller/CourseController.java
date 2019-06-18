package edu.mum.cs544.MumRegistrationApi.Controller;

import edu.mum.cs544.MumRegistrationApi.Model.Course;
import edu.mum.cs544.MumRegistrationApi.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    private CourseService service;
    @GetMapping()
    public List<Course> getCourses() {
        return service.getCourses();
    }

    @GetMapping(path = "/{id}")
    public Course getCourseById(@PathVariable long id){
        return service.getCourse(id);
    }

    @PostMapping()
    public void addCourse(@RequestBody Course course){
        service.addCourse(course);
    }

    @PutMapping()
    public void updateCourse(@RequestBody Course course){
        service.updateCourse(course);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCourse(@PathVariable long id){
        service.deleteCourse(id);
    }

    @GetMapping(path = "/courselevels")
    public List<Course> getCourseLevels(){
     return null;
    }

}
