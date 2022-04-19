package by.library.controller;

import by.library.dto.UserDto;
import by.library.model.User;
import by.library.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public List<User> getAll(){

        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id){

        return userService.get(id);
    }

    @PostMapping
    public UserDto create(@RequestBody UserDto userDto) {

        userService.create(userDto);

        return userDto;
    }

    @PutMapping
    public UserDto update(@RequestBody UserDto userDto){

        userService.update(userDto);

        return userDto;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        userService.delete(id);
    }
}