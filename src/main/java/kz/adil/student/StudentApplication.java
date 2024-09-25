package kz.adil.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
public class StudentApplication{
	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

}