package kz.adil.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HiController{
	@GetMapping("/greet")
	public String greet(@RequestParam(value= "name", defaultValue = "Guest") String name){
		return "Hello, " + name;
	}
}

@SpringBootApplication
public class StudentApplication{
	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}
}