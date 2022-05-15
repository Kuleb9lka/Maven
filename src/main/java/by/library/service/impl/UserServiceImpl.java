package by.library.service.impl;

import by.library.dto.admin.UserDtoForAdmin;
import by.library.exception.UserNotFoundException;
import by.library.mapper.AdminMapper;
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

    private final AdminMapper adminMapper;

    @Override
    public UserDtoForAdmin get(Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No such user"));

        return adminMapper.toUserDto(user);
    }

    @Override
    public List<UserDtoForAdmin> getAll() {

        return adminMapper.mapToUserDtoList(userRepository.findAll());
    }

    @Override
    public UserDtoForAdmin create(UserDtoForAdmin userDto) {

        User convertUser = adminMapper.toUser(userDto);

        User user = userRepository.save(convertUser);

        return adminMapper.toUserDto(user);
    }

    @Override
    public UserDtoForAdmin update(UserDtoForAdmin userDto) {

        User convertUser = adminMapper.toUser(userDto);

        User user = userRepository.save(convertUser);

        return adminMapper.toUserDto(user);
    }

    @Override
    public void delete(Long id) {

        userRepository.deleteById(id);
    }
}