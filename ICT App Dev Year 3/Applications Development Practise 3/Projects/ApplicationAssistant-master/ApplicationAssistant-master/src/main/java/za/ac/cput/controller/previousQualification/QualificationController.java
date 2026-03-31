package za.ac.cput.controller.previousQualification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.previousQualification.Qualification;
import za.ac.cput.factory.previousQualification.QualificationFactory;
import za.ac.cput.service.previousQualification.impl.QualificationServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/qualification")
public class QualificationController {

    @Autowired
    private QualificationServiceImpl qualificationService;

    @PostMapping("/create")
    public Qualification create(@RequestBody Qualification qualification)
    {
        qualification = QualificationFactory.createQualification(qualification.getLevelOfQualifications());
        return qualificationService.create(qualification);
    }

    @GetMapping("/all")
    public Set<Qualification> getAll()
    {
        return qualificationService.getAll();
    }

    @GetMapping("/read/{id}")
    public Qualification read(@PathVariable String id)
    {
       return qualificationService.read(id);
    }

    @PostMapping("/update")
    public Qualification update(@RequestBody Qualification qualification)
    {
        return qualificationService.update(qualification);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String qualificationId)
    {
        return qualificationService.delete(qualificationId);
    }

    @GetMapping("/allwith/{letter}")
    public Set<Qualification> getAllStartingWith(@PathVariable String letter)
    {
        return qualificationService.getAllStartingWith(letter);
    }
}
