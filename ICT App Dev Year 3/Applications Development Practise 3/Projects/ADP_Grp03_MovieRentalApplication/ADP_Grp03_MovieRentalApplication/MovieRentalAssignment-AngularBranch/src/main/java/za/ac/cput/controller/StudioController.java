package za.ac.cput.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Studio;
import za.ac.cput.factory.StudioFactory;
import za.ac.cput.service.StudioService;

import java.util.List;


/* StudioController.java

        Author: Marchello Carolus 218234457

        */
@Deprecated
@RestController
@RequestMapping("/studio")
public class StudioController {
    @Autowired
    private StudioService studioService;

    //@RequestMapping( value = "/create", method = RequestMethod.POST)
    @PostMapping("/create")
    public Studio create(@RequestBody Studio studio) {
        Studio newStudio = StudioFactory.build(studio.getStudioId(), studio.getStudioName());

        return studioService.create(newStudio);
    }

    @GetMapping("/read/{id}")
    public Studio read(@PathVariable String id){
        return studioService.read(id);

    }

    @PostMapping("/update")
    public Studio update(@RequestBody Studio studio){
        Studio updateStudio = StudioFactory.build(studio.getStudioId(), studio.getStudioName());
        return studioService.update(updateStudio);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return studioService.delete(id);

    }

    @GetMapping("/getAll")
    public List<Studio> getAll(){
        return studioService.getAll();
    }

}
