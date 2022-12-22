package com.springapi.farhadcodesacpblog.Service;

import com.springapi.farhadcodesacpblog.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository _repository){
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
            u.setUsername(updatedUser.getUsername());
            u.setEmail(updatedUser.getEmail());
}
