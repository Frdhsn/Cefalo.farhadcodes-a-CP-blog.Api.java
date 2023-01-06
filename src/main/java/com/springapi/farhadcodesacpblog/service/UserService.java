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
    private UserRepository userRepository;
    @Autowired
    private UserValidation userValidation;
    @Autowired
    private UserDTOMapper userDTOMapper;

    public List<UserDTO> getAllUsers() {
        List<Users> fetchedUsers = userRepository.findAll();
        return fetchedUsers.stream().map(x->userDTOMapper.mapDetails(x)).toList();
    }

    public UserDTO getUserById(int id) {
        Optional<Users> fetchedUser = userRepository.findById(id);

        if(fetchedUser.isPresent()){
            UserDTO user = userDTOMapper.mapDetails(fetchedUser.get());
            return user;
        }
        throw new NotFoundException(Users.class,"id",String.valueOf(id));
    }
    public UserDTO updateUser(int id, Users updatedUser) {
        Optional<Users> user = userRepository.findById(id);

        if(user.isEmpty()) throw new NotFoundException(Users.class,"id",String.valueOf(id));

        if (userValidation.verify(user.get())) {
            user.get().setName(updatedUser.getName());
            user.get().setEmail(updatedUser.getEmail());
//            user.get().setPassword(updatedUser.getPassword());
            userRepository.save(user.get());

            UserDTO userDTO = userDTOMapper.mapDetails(user.get());
            return userDTO;
        }
        throw new UnauthorizedException("Unauthorized user");
    }
    public void deleteUser(int id){
        Optional<Users> user = userRepository.findById(id);
        if(user.isEmpty()) throw new NotFoundException(Users.class,"id",String.valueOf(id));
        if(userValidation.verify(user.get())){
            userRepository.deleteById(id);
            return;
        }
        throw new UnauthorizedException("Unauthorized user");
    }
}
