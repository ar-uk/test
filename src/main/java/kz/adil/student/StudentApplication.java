package kz.adil.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
class HiController{
	@GetMapping("/greet")
	public String greet(@RequestParam(value= "name", defaultValue = "Guest") String name) {
		return "Hello, " + name;
	}
}

@RestController
class BookController{
	@PostMapping("/books")
	public Book HandleBook(@RequestBody Book book){
		book.setStatus("recieved");
		return book;
	}
}

@SpringBootApplication
public class StudentApplication{
	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

}