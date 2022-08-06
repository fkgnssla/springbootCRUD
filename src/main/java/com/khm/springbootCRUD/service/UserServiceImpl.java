package com.khm.springbootCRUD.service;

import com.khm.springbootCRUD.model.User;
import com.khm.springbootCRUD.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public void createUser(User user) { //생성
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) { //삭제
        Optional<User> findUserOptional = userRepository.findById(id);
        User user = findUserOptional.orElseThrow(() -> new NoSuchElementException());
        userRepository.delete(user);
    }

    @Override
    public void updateUser(User user) { //수정
        Optional<User> findUserOptional = userRepository.findById(user.getId());
        if(findUserOptional.isPresent()) {
            User findUser = findUserOptional.get();
            findUser.change(user.getName(), user.getAge(), user.getAddress());
        }
    }

    @Override
    public List<User> findUsers() {
        return userRepository.findAll();
    }
}
