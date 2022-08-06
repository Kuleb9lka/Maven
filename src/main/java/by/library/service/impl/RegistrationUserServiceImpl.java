package by.library.service.impl;

import by.library.constant.Constant;
import by.library.exception.UserIsAlreadyExistException;
import by.library.model.User;
import by.library.dto.RegistrationUserDto;
import by.library.service.RegistrationUserService;
import by.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Set;

@Component
@Service
public class RegistrationUserServiceImpl implements RegistrationUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerNewUserAccount(RegistrationUserDto userDto) {

        if (isUserExist(userDto.getLogin())){

            throw new UserIsAlreadyExistException("There is an account with that login: "
                    + userDto.getLogin());
        }

        User user = new User();

        user.setLogin(userDto.getLogin());
        user.setPassword(passwordEncoder().encode(userDto.getPassword()));
        user.setRoles(Set.of(Constant.USER_ROLE));
        user.setStatus(Constant.ACTIVE_STATUS);

        return userRepository.save(user);
    }

    private boolean isUserExist(String login){

        return userRepository.findByLogin(login).isPresent();
    }

    private PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder(12);
    }
}
