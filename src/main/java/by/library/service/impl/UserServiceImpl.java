package by.library.service.impl;

import by.library.dto.UserDto;
import by.library.model.User;
import by.library.repository.UserRepository;
import by.library.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User get(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);

        return optionalUser.get();
    }

    @Override
    public List<User> getAll() {

        return userRepository.findAll();
    }

    @Override
    public User create(UserDto userDto) {

        User user = new User(userDto.getId(), userDto.getLogin(),
                userDto.getPassword(), userDto.getRole());

        userRepository.save(user);

        return user;
    }

    @Override
    public User update(UserDto userDto) {

        User user = new User(userDto.getLogin(), userDto.getPassword(), userDto.getRole());

        userRepository.save(user);

        return user;
    }

    @Override
    public void delete(Long id) {

        userRepository.deleteById(id);
    }
}
