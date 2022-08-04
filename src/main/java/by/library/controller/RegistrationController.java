package by.library.controller;

import by.library.exception.UserIsAlreadyExistException;
import by.library.model.User;
import by.library.dto.RegistrationUserDto;
import by.library.service.impl.RegistrationUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/reg")
public class RegistrationController {

    @Autowired
    private RegistrationUserServiceImpl registrationUserServiceImpl;

    private ModelAndView mav;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        RegistrationUserDto userDto = new RegistrationUserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping("/registration")
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Validated RegistrationUserDto userDto, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return new ModelAndView("registration");
        }

        try{

            User registered = registrationUserServiceImpl.registerNewUserAccount(userDto);

        } catch (UserIsAlreadyExistException uaeEx) {

            mav.addObject("message", "An account for that username/email already exists.");

            return mav;
        }

        return new ModelAndView("success", "user", userDto);
    }
}
