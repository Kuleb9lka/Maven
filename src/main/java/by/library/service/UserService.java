package by.library.service;

import by.library.dto.admin.AdminUserDto;
import by.library.model.User;

import java.util.List;

public interface UserService {

    AdminUserDto get(Long id);
    List<AdminUserDto> getAll();
    AdminUserDto create(AdminUserDto adminUserDto);
    AdminUserDto update(AdminUserDto adminUserDto);
    void delete(Long id);
}
