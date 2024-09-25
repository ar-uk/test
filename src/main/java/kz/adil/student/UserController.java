package kz.adil.student;

import kz.adil.student.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.List;
/*
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
*/

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private Map<Long, User> map = new HashMap<>();
    public UserController() {
        map.put(1L, new User(1L, "Mohammed", 1));
        map.put(2L, new User(2L, "Dil", 18));
    }
    @PutMapping("{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User newuser) {
        User user = map.get(id);

        if (user == null) {
            return "not foud";
        }
        user.setName(newuser.getName());
        user.setAge(newuser.getAge());
        map.put(id, user);

        return  "updated " + id;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>("message" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/error")
    public String triggerError() {
        throw new RuntimeException(".");
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        User user = map.get(id);

        if (user == null) {
            return "not found.";
        }

        map.remove(id);
        return id + " has been deleted";
    }
    @PostMapping("/create")
    public String createUser(@RequestBody User user) {
        map.put(user.getId(), user);
        return "created";
    }

    @GetMapping("/list")
    public List<User> listUsers(
            @RequestParam String name,
            @RequestParam int page,
            @RequestParam int size)
    {
        List<User> filteredusers = map.values().stream()
                .filter(user -> name == null || user.getName().equalsIgnoreCase(name))
                .skip(page * size)
                .limit(size)
                .collect(Collectors.toList());

        return filteredusers;
    }
}
