package com.springapi.farhadcodesacpblog.utils;

import com.springapi.farhadcodesacpblog.dtos.UserDTO;
import com.springapi.farhadcodesacpblog.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UserDTOMapper {
    public UserDTO mapDetails(Users user){
        UserDTO _userdata = new UserDTO();
        _userdata.setId(user.getId());
        _userdata.setName(user.getName());
        _userdata.setEmail(user.getEmail());
        return _userdata;
    }
}
