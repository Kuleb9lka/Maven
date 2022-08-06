package by.library.service;

import by.library.model.User;
import by.library.dto.RegistrationUserDto;

public interface RegistrationUserService {

    User registerNewUserAccount(RegistrationUserDto userDto);
}
