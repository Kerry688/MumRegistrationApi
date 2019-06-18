package edu.mum.cs544.MumRegistrationApi.Controller;

import edu.mum.cs544.MumRegistrationApi.Model.Result;
import edu.mum.cs544.MumRegistrationApi.Model.Section;
import edu.mum.cs544.MumRegistrationApi.Model.Student;
import edu.mum.cs544.MumRegistrationApi.Service.StudentService;
import edu.mum.cs544.MumRegistrationApi.dto.SectionDto;
import edu.mum.cs544.MumRegistrationApi.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping()
    public List<Student> getAll() {
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public Student get(@PathVariable long id) {
        return service.get(id);
    }

    @PostMapping()
    public Result add(@RequestBody Student st) {
        return service.add(st);
    }

    @PutMapping()
    public Result update(@RequestBody Student st) {
        return service.update(st);
    }

    @DeleteMapping(path = "/{id}")
    public Result delete(@PathVariable long id){
        return service.delete(id);
    }

    @GetMapping(path = "/enrolledsections/{userId}")
    public List<Section> getEnrolledSections(@PathVariable long userId){
        return service.getEnrolledSections(userId);
    }

    @PutMapping(path = "/registersections/{userId}")
    public Result registerForSections(@PathVariable long userId, @RequestBody int[] sectionIdArray){
        return service.registerForSections(userId, sectionIdArray);
    }
}
