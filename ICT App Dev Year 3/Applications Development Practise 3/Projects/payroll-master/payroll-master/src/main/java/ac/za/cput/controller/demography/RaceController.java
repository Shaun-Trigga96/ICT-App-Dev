package ac.za.cput.controller.demography;

import ac.za.cput.domain.ResponseObj;
import ac.za.cput.domain.demography.Race;
import ac.za.cput.factory.ResponseObjFactory;
import ac.za.cput.factory.demography.RaceFactory;
import ac.za.cput.service.demography.RaceService;
import ac.za.cput.service.demography.impl.RaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/payroll/lookup/race")
public class RaceController {

    @Autowired
    private RaceService raceService;

    @PostMapping(value = "/create/{race}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createRace(@PathVariable String race) {
        System.out.println("Entered Value: " + race);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Race created!");
        Race savedRace;
        if (race == null || race.trim().isEmpty() || race.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide a race!");
        } else {
            savedRace = raceService.retrieveByDesc(race);
            if (savedRace != null) {
                responseObj.setResponseDescription("Race already exist!");
            } else {
                savedRace = RaceFactory.buildRace(race);
                savedRace = raceService.create(savedRace);
            }
            responseObj.setResponse(savedRace);
        }
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        List<Race> races = raceService.getAll();
        responseObj.setResponse(races);
        return ResponseEntity.ok(responseObj);
    }
}
