package com.khm.springbootCRUD.service;

import com.khm.springbootCRUD.model.User;
import com.khm.springbootCRUD.repository.UserRepository;

import java.util.List;

public interface UserService {
    void createUser(User user);
    void deleteUser(Long id);
    void updateUser(User user);
    List<User> findUsers();
}
