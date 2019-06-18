package edu.mum.cs544.MumRegistrationApi.Controller;
import edu.mum.cs544.MumRegistrationApi.Model.Block;
import edu.mum.cs544.MumRegistrationApi.Service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api/block")
public class BlockController {

    @Autowired
    private BlockService service;

    @GetMapping()
    public List<Block> getBlocks() {
        return service.getBlocks();
    }

    @PostMapping()
    public Long addBlock(@RequestBody Block block){

        return service.addBlock(block);
    }

    @PutMapping()
    public void updateBlock(@RequestBody Block block){

        service.updateBlock(block);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBlock(@PathVariable long id){ service.deleteBlock(id);
    }


}
