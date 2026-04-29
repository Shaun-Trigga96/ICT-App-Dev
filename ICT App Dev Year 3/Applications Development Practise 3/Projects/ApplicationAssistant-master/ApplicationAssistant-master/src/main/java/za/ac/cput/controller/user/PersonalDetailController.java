package za.ac.cput.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.user.PersonalDetail;
import za.ac.cput.factory.user.PersonalDetailFactory;
import za.ac.cput.service.user.impl.PersonalDetailServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/personalDetail")
public class PersonalDetailController {

    @Autowired
    private PersonalDetailServiceImpl personalDetailService;


    @PostMapping("/create")
    public PersonalDetail create(@RequestBody PersonalDetail personalDetail){
        PersonalDetail newPersonalDetail = PersonalDetailFactory.createPersonalDetails("cw@gmail.com", "021345", "Higher Certificate");

        return personalDetailService.create(newPersonalDetail);

    }

    @GetMapping("/all")
    public Set<PersonalDetail> getAll(){
        return personalDetailService.getAll();
    }

    @GetMapping("/read/{personalDetailid}")
    public PersonalDetail read(@PathVariable String personalDetailid) { return personalDetailService.read(personalDetailid);}

    @PostMapping("/update")
    public PersonalDetail update(@RequestBody PersonalDetail personalDetail) {
        return personalDetailService.update(personalDetail);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return personalDetailService.delete(id);
    }

}
