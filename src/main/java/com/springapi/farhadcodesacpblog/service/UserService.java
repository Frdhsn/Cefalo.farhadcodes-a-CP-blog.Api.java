package com.springapi.farhadcodesacpblog.service;

import com.springapi.farhadcodesacpblog.dtos.UserDTO;
import com.springapi.farhadcodesacpblog.repository.UserRepository;
import com.springapi.farhadcodesacpblog.entity.User;
import com.springapi.farhadcodesacpblog.utils.UserDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserDTOMapper userDTOMapper;

    public List<UserDTO> getAllUsers() {
        List<User> fetchedUsers = repository.findAll();
        return fetchedUsers.stream().map(x->userDTOMapper.mapDetails(x)).toList();
    }

    public UserDTO getUserById(int Id) {
        Optional<User> fetchedUser = repository.findById(Id);

        UserDTO user = userDTOMapper.mapDetails(fetchedUser.get());
        return user;
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public UserDTO updateUser(int id, User updatedUser) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            User u = user.get();
            u.setName(updatedUser.getName());
            u.setEmail(updatedUser.getEmail());
            repository.save(u);

            UserDTO userDTO = userDTOMapper.mapDetails(user.get());
            return userDTO;
        }
        return null;
    }
    public void deleteUser(int id){
        Optional<User> user = repository.findById(id);
        if(user.isPresent()){
            repository.deleteById(id);
            return;
        }
    }
}
