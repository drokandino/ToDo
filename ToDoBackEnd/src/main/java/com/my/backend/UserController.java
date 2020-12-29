package com.my.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/addUser")
    void addUser(@RequestBody User user){
        userRepository.save(user);
    }

    @GetMapping("/getUsers")
    List<User> getUsers(){
        return (List<User>) userRepository.findAll();
    }
}
