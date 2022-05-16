package by.library.service;

import by.library.dto.admin.UserDtoForAdmin;

import java.util.List;

public interface UserService {

    UserDtoForAdmin get(Long id);
    List<UserDtoForAdmin> getAll();
    UserDtoForAdmin create(UserDtoForAdmin userDtoForAdmin);
    UserDtoForAdmin update(UserDtoForAdmin userDtoForAdmin);
    void delete(Long id);
}
