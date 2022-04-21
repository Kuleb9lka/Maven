package by.library.service.impl;

import by.library.dto.admin.AdminUserDto;
import by.library.model.User;
import by.library.repository.UserRepository;
import by.library.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public AdminUserDto get(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);

        AdminUserDto adminUserDto = new AdminUserDto(optionalUser.get().getId(), optionalUser.get().getLogin(),
                optionalUser.get().getPassword(), optionalUser.get().getRole());

        return adminUserDto;
    }

    @Override
    public List<AdminUserDto> getAll() {

        List<AdminUserDto> dtoList = new ArrayList<>();

        for (User user : userRepository.findAll()) {

            AdminUserDto adminUserDto = new AdminUserDto(user.getId(), user.getLogin(),
                     user.getPassword(), user.getRole());

            dtoList.add(adminUserDto);
        }

        return dtoList;
    }

    @Override
    public AdminUserDto create(AdminUserDto adminUserDto) {

        User user = new User(adminUserDto.getId(), adminUserDto.getLogin(),
                adminUserDto.getPassword(), adminUserDto.getRole());

        userRepository.save(user);

        return adminUserDto;
    }

    @Override
    public AdminUserDto update(AdminUserDto adminUserDto) {

        User user = new User(adminUserDto.getId(), adminUserDto.getLogin(), adminUserDto.getPassword(), adminUserDto.getRole());

        userRepository.save(user);

        return adminUserDto;
    }

    @Override
    public void delete(Long id) {

        userRepository.deleteById(id);
    }
}
