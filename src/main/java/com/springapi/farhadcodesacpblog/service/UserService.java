package com.springapi.farhadcodesacpblog.service;

import com.springapi.farhadcodesacpblog.repository.UserRepository;
import com.springapi.farhadcodesacpblog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public UserService(UserRepository _repository) {
        repository = _repository;
    }

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
