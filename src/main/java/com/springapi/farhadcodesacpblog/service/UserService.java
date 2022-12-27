package com.springapi.farhadcodesacpblog.service;

import com.springapi.farhadcodesacpblog.entity.User;
import com.springapi.farhadcodesacpblog.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository repository;

    public List<User> getAllUsers() {

        return repository.findAll();
    }
    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public Optional<User> updateUser(Long id, User updatedUser) {
        Optional<User> user = repository.findById(id);

        if (user.isPresent()) {
            User u = user.get();
            u.setName(updatedUser.getName());
            u.setEmail(updatedUser.getEmail());
        }
        return user;
    }
}
