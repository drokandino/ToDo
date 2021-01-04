package com.my.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        System.out.println("Dodavanje korisnikia" + user.toString());
    }
    
    @PostMapping("/user")
    Map<String, String> authUser(@RequestBody User user){
        HashMap<String, String> object = new HashMap<>();
        boolean exists = userRepository.existsByName(user.getName());

        if(exists)
            object.put("succes", "true");
        else
            object.put("succes", "false");

        return object;
    }
    
    @GetMapping("/getUsers")
    List<User> getUsers(){
        return (List<User>) userRepository.findAll();
    }
}
