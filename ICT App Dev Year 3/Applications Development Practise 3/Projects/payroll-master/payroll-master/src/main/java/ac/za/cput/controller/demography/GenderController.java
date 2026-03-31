package ac.za.cput.controller.demography;


import ac.za.cput.domain.ResponseObj;
import ac.za.cput.domain.demography.Gender;
import ac.za.cput.factory.ResponseObjFactory;
import ac.za.cput.factory.demography.GenderFactory;
import ac.za.cput.service.demography.GenderService;
import ac.za.cput.service.demography.impl.GenderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/payroll/lookup/gender")
public class GenderController {

    @Autowired
    private GenderService genderService;

    @PostMapping(value = "/create/{gender}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createGender(@PathVariable String gender) {
        System.out.println("Entered Value: " + gender);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Gender created!");
        Gender savedGender;
        if (gender == null || gender.trim().isEmpty() || gender.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide a gender!");
        } else {
            savedGender = genderService.retrieveByDesc(gender);
            if (savedGender != null) {
                responseObj.setResponseDescription("Gender already exist!");
            } else {
                savedGender = GenderFactory.buildGender(gender);
                savedGender = genderService.create(savedGender);
            }
            responseObj.setResponse(savedGender);
        }
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        List<Gender> genders = genderService.getAll();
        responseObj.setResponse(genders);
        return ResponseEntity.ok(responseObj);
    }
}
