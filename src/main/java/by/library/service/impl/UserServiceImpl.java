package by.library.service.impl;

import by.library.dto.admin.AdminUserDto;
import by.library.mapper.admin.AdminUserMapper;
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

        return AdminUserMapper.INSTANCE.toDto(optionalUser.get());
    }

    @Override
    public List<AdminUserDto> getAll() {

        List<AdminUserDto> dtoList = new ArrayList<>();

        for (User user : userRepository.findAll()) {

            AdminUserDto adminUserDto = AdminUserMapper.INSTANCE.toDto(user);

            dtoList.add(adminUserDto);
        }

        return dtoList;
    }

    @Override
    public AdminUserDto create(AdminUserDto userDto) {

        User user = AdminUserMapper.INSTANCE.toEntity(userDto);

        userRepository.save(user);

        return userDto;
    }

    @Override
    public AdminUserDto update(AdminUserDto userDto) {

        User user = AdminUserMapper.INSTANCE.toEntity(userDto);

        userRepository.save(user);

        return userDto;
    }

    @Override
    public void delete(Long id) {

        userRepository.deleteById(id);
    }
}
