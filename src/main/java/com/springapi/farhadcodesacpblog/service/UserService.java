package com.springapi.farhadcodesacpblog.service;

import com.springapi.farhadcodesacpblog.dtos.UserDTO;
import com.springapi.farhadcodesacpblog.exceptions.NotFoundException;
import com.springapi.farhadcodesacpblog.exceptions.UnauthorizedException;
import com.springapi.farhadcodesacpblog.repository.UserRepository;
import com.springapi.farhadcodesacpblog.entity.Users;
import com.springapi.farhadcodesacpblog.utils.UserDTOMapper;
import com.springapi.farhadcodesacpblog.utils.authorization.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserValidation userValidation;
    @Autowired
    private UserDTOMapper userDTOMapper;

    public List<UserDTO> getAllUsers() {
        List<Users> fetchedUsers = repository.findAll();
        return fetchedUsers.stream().map(x->userDTOMapper.mapDetails(x)).toList();
    }

    public UserDTO getUserById(int id) {
        Optional<Users> fetchedUser = repository.findById(id);

        if(fetchedUser.isPresent()){
            UserDTO user = userDTOMapper.mapDetails(fetchedUser.get());
            return user;
        }
        throw new NotFoundException(Users.class,"id",String.valueOf(id));
    }
    public UserDTO updateUser(int id, Users updatedUser) {
        Optional<Users> user = repository.findById(id);

        if(user.isEmpty()) throw new NotFoundException(Users.class,"id",String.valueOf(id));

        if (userValidation.verify(user.get())) {
            Users u = user.get();
            u.setName(updatedUser.getName());
            u.setEmail(updatedUser.getEmail());
            u.setPassword(updatedUser.getPassword());
            repository.save(u);

            UserDTO userDTO = userDTOMapper.mapDetails(user.get());
            return userDTO;
        }
        throw new UnauthorizedException("Unauthorized user");
    }
    public void deleteUser(int id){
        Optional<Users> user = repository.findById(id);
        if(user.isEmpty()) throw new NotFoundException(Users.class,"id",String.valueOf(id));
        if(userValidation.verify(user.get())){
            repository.deleteById(id);
            return;
        }
        throw new UnauthorizedException("Unauthorized user");
    }
}
