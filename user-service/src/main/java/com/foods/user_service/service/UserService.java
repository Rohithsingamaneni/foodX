package com.foods.user_service.service;

import com.foods.user_service.exception.UserNotFoundException;
import com.foods.user_service.model.User;
import com.foods.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("User with id "+id+" not found"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
