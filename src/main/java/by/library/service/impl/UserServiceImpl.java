package by.library.service.impl;

import by.library.dto.admin.UserDtoForAdmin;
import by.library.exception.UserNotFoundException;
import by.library.mapper.admin.AdminUserMapper;
import by.library.mapper.list.UserListMapper;
import by.library.model.User;
import by.library.repository.UserRepository;
import by.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDtoForAdmin get(Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No such user"));

        return AdminUserMapper.INSTANCE.toDto(user);
    }

    @Override
    public List<UserDtoForAdmin> getAll() {

        return UserListMapper.INSTANCE.toDtoList(userRepository.findAll());
    }

    @Override
    public UserDtoForAdmin create(UserDtoForAdmin userDto) {

        User user = AdminUserMapper.INSTANCE.toEntity(userDto);

        userRepository.save(user);

        return AdminUserMapper.INSTANCE.toDto(user);
    }

    @Override
    public UserDtoForAdmin update(UserDtoForAdmin userDto) {

        User user = AdminUserMapper.INSTANCE.toEntity(userDto);

        userRepository.save(user);

        return AdminUserMapper.INSTANCE.toDto(user);
    }

    @Override
    public void delete(Long id) {

        userRepository.deleteById(id);
    }
}
