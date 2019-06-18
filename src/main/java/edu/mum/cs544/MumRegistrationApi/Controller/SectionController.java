package edu.mum.cs544.MumRegistrationApi.Controller;

import edu.mum.cs544.MumRegistrationApi.Model.Result;
import edu.mum.cs544.MumRegistrationApi.Model.Section;
import edu.mum.cs544.MumRegistrationApi.Service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api/section")
public class SectionController {

    @Autowired
    private SectionService service;

    @GetMapping()
    public List<Section> getSections() {
        return service.getSections();
    }

    @GetMapping(path = "/{id}")
    public Section getSectionById(@PathVariable long id) {
        return service.getSection(id);
    }

    @PostMapping()
    public Result addSection(@RequestBody Section st) {
        return service.addSection(st);
    }

    @PutMapping()
    public Result updateSection(@RequestBody Section st) {
        return service.updateSection(st);
    }

    @DeleteMapping(path = "/{id}")
    public Result deleteSection(@PathVariable Long id){
        return service.deleteSection(id);
    }

    @GetMapping(path = "/availablesections")
    public List<Section> getAvailableSections(){
        return service.getAvailableSections();
    }
}
