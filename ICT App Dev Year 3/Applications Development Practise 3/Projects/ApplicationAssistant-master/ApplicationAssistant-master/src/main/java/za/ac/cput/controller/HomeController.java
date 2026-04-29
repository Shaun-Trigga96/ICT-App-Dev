package za.ac.cput.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping({"/", "/index.xyz"})
    String home(){
        return "Application Assistant App Demo";
    }
}
