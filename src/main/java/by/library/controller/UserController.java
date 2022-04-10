package by.library.controller;

import by.library.model.user.User;
import by.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> allUsers() {

        Optional<User> optionalUser = userRepository.findByLogin("bogdan");

        if (optionalUser.isPresent()) {

            User user = optionalUser.get();
        }

        return userRepository.findAll();
    }


//    @GetMapping("/get-user")
//    public User getUser(){
//        return new User(1, "vasya", "dsfsdf", "sdfsdfsdf", "male", 12);
//    }
//
//    @PostMapping("/save")
//    public void addUser(@RequestBody User user){
//
//        System.out.println(user);
//    }


}