package me.dio.service.impl;

import me.dio.UserRepository;
import me.dio.domain.model.User;
import me.dio.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceimpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceimpl(UserRepository userRepository){this.userRepository = userRepository;}
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())){throw new IllegalArgumentException("This User Id already exists");}
        return userRepository.save(userToCreate);
    }
}
