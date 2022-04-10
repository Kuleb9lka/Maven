package by.library.controller;


import by.library.dto.AuthenticationDto;
import by.library.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @GetMapping
    public AuthenticationDto login(AuthenticationDto authenticationDto){

        return authenticationDto;
    }
}
