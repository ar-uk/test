package kz.adil.student.lab3;


import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
class Lab3 {
    @GetMapping("/currentTime")
    public String ShowTime(){
        return LocalDateTime.now().toString();
    }


    @GetMapping("/api")
    public List<Integer> ShowNumbers(@RequestParam(value = "q") int q){
        List<Integer> num = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            num.add(i);
        }
        return num;
    }
    private final int number = new Random().nextInt(500);
    @GetMapping("/random_number")
    public int RandomNumber(){
        return number;
    }

    @GetMapping("/fib")
    public int FibNum(@RequestParam(value = "number") int num){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(0);
        numbers.add(1);
        numbers.add(1);
        for (int i = 1; i < num; i++) {
            numbers.add(numbers.get(i) + numbers.get(i + 1));
        }
        return numbers.getLast();
    }

    @GetMapping("/{string}")
    public String ReverseString(@PathVariable String sttring){
        return new StringBuilder(sttring).reverse().toString();
    }

    @GetMapping("/guesser")
    public String Guessr(@RequestParam(value = "num") int num){
        if(num ==number)
            return "Grats";
        else if (num>number)
            return "aim lower";
        else
        return "too low";
    }
}
