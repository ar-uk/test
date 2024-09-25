package kz.adil.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HiController{
    @GetMapping("/greet")
    public String greet(@RequestParam(value= "name", defaultValue = "Guest") String name) {
        return "Hello, " + name;
    }
}