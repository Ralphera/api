package com.udemyapi.api.services;

import com.udemyapi.api.domain.User;
import com.udemyapi.api.domain.dto.UserDTO;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
    User create(UserDTO obj);
    User update(UserDTO obj);
    void delete(Integer id);

}
