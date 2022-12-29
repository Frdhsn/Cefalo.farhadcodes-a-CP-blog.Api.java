package com.springapi.farhadcodesacpblog.service;

import com.springapi.farhadcodesacpblog.dtos.UserDTO;
import com.springapi.farhadcodesacpblog.repository.UserRepository;
import com.springapi.farhadcodesacpblog.entity.Users;
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
        List<Users> fetchedUsers = repository.findAll();
        return fetchedUsers.stream().map(x->userDTOMapper.mapDetails(x)).toList();
    }

    public UserDTO getUserById(int Id) {
        Optional<Users> fetchedUser = repository.findById(Id);

        UserDTO user = userDTOMapper.mapDetails(fetchedUser.get());
        return user;
    }

    public Users createUser(Users user) {
        return repository.save(user);
    }

    public UserDTO updateUser(int id, Users updatedUser) {
        Optional<Users> user = repository.findById(id);
        if (user.isPresent()) {
            Users u = user.get();
            u.setName(updatedUser.getName());
            u.setEmail(updatedUser.getEmail());
            repository.save(u);

            UserDTO userDTO = userDTOMapper.mapDetails(user.get());
            return userDTO;
        }
        return null;
    }
    public void deleteUser(int id){
        Optional<Users> user = repository.findById(id);
        if(user.isPresent()){
            repository.deleteById(id);
            return;
        }
    }
}
