package by.library.controller;

import by.library.dto.admin.AdminUserDto;
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
    public List<AdminUserDto> getAll(){

        return userService.getAll();
    }

    @GetMapping("/{id}")
    public AdminUserDto get(@PathVariable Long id){

        return userService.get(id);
    }

    @PostMapping
    public AdminUserDto create(@RequestBody AdminUserDto userDto) {

        return userService.create(userDto);
    }

    @PutMapping
    public AdminUserDto update(@RequestBody AdminUserDto userDto){

        return userService.update(userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        userService.delete(id);
    }
}