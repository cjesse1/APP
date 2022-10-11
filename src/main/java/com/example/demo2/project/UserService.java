package com.example.demo2.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public User getUserbyId(Integer id) {
        return userRepository.findById(id).get();
    }

    public void addNewUser(User user) {
        userRepository.save(user);
    }

    public User updateUser(Integer id, User user) {
        User savedUser = userRepository.findById(id).get();
        savedUser.setEmail(user.getEmail());
        savedUser.setFirstName(user.getFirstName());
        savedUser.setPassword(user.getPassword());
        savedUser.setLastName(user.getLastName());
        userRepository.save(savedUser);
        return savedUser;
    }

    public User updateUserEmail(Integer id, User user) {
        User savedUser = userRepository.findById(id).get();
        savedUser.setEmail(user.getEmail());
        userRepository.save(savedUser);
        return savedUser;
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
