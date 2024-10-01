package kz.adil.student.lab2;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class BookController {
    @PostMapping("/books")
    public Book HandleBook(@RequestBody Book book) {
        book.setStatus("recieved");
        return book;
    }
}
