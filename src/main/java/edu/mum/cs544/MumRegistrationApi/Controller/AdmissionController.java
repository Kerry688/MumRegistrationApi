package edu.mum.cs544.MumRegistrationApi.Controller;

import edu.mum.cs544.MumRegistrationApi.Model.Result;
import edu.mum.cs544.MumRegistrationApi.Model.Admission;
import edu.mum.cs544.MumRegistrationApi.Service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api/admission")
public class AdmissionController {

    @Autowired
    private AdmissionService service;

    @GetMapping()
    public List<Admission> getAll() {
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public Admission get(@PathVariable long id) {
        return service.get(id);
    }

    @PostMapping()
    public Result add(@RequestBody Admission st) {
        return service.add(st);
    }

    @PutMapping()
    public Result update(@RequestBody Admission st) {
        return service.update(st);
    }

    @DeleteMapping(path = "/{id}")
    public Result delete(@PathVariable long id){
        return service.delete(id);
    }


//    @GetMapping(path = "/enrolledsections/{userId}")
//    public List<SectionDto> getEnrolledSections(@PathVariable long userId){
//        return service.getEnrolledSections(userId);
//    }
//
//    @PutMapping(path = "/registersections/{userId}")
//    public Result registerForSections(@PathVariable long userId, @RequestBody int[] sectionIdArray){
//        return service.registerForSections(userId, sectionIdArray);
//    }
}
