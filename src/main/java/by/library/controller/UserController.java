package by.library.controller;

import by.library.dto.admin.UserDtoForAdmin;
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
    public List<UserDtoForAdmin> getAll(){

        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDtoForAdmin get(@PathVariable Long id){

        return userService.get(id);
    }

    @PostMapping
    public UserDtoForAdmin create(@RequestBody UserDtoForAdmin userDto) {

        return userService.create(userDto);
    }

    @PutMapping
    public UserDtoForAdmin update(@RequestBody UserDtoForAdmin userDto){

        return userService.update(userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        userService.delete(id);
    }
}