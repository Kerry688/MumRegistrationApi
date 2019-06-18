package edu.mum.cs544.MumRegistrationApi.Controller;
import edu.mum.cs544.MumRegistrationApi.Model.Entry;
import edu.mum.cs544.MumRegistrationApi.Service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api/entry")
public class EntryController {
    @Autowired
    private EntryService service;

    @GetMapping()
    public List<Entry> getEntries() {

        return service.getEntries();
    }

    @GetMapping(path = "/{id}")
    public Entry getEntryById(@PathVariable long id){
        return service.getEntry(id);
    }

    @PostMapping()
    public Long addEntry(@RequestBody Entry entry){
         return service.addEntry(entry);
    }

    @PutMapping()
    public void updateEntry(Entry entry){
        System.out.println("hello i am in controller");
        service.updateEntry(entry);
       // System.out.println("hello i am in controller");
    }

    @DeleteMapping(path = "/{id}")
    public void deleteEntry(@PathVariable long id){
        service.deleteEntry(id);
    }
}
