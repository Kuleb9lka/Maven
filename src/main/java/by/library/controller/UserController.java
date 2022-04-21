package by.library.controller;

import by.library.dto.admin.AdminUserDto;
import by.library.model.User;
import by.library.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public AdminUserDto create(@RequestBody AdminUserDto adminUserDto) {

        return userService.create(adminUserDto);
    }

    @PutMapping
    public AdminUserDto update(@RequestBody AdminUserDto adminUserDto){

        return userService.update(adminUserDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        userService.delete(id);
    }
}