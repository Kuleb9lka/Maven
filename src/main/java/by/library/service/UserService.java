package by.library.service;

import by.library.dto.UserDto;
import by.library.model.User;

import java.util.List;

public interface UserService {

    User get(Long id);
    List<User> getAll();
    User create(UserDto userDto);
    User update(UserDto userDto);
    void delete(Long id);
}
