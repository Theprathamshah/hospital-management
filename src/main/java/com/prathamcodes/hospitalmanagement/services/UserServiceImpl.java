package com.prathamcodes.hospitalmanagement.services;

import com.prathamcodes.hospitalmanagement.model.User;
import com.prathamcodes.hospitalmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl {
    private final UserRepository userRepository;

    public List<User> findAll(){
       return (List<User>) userRepository.findAll();
    }
    public User findUserByEmail(String email){
        return userRepository.getUserByEmail(email);
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User updateUser(User user){
        User savedUser = userRepository.findById(user.getId()).orElseThrow(()->new RuntimeException("User not found"));
        savedUser.setAddress(user.getAddress());
        savedUser.setName(user.getName());
        savedUser.setBirthday(user.getBirthday());
        savedUser.setRole(user.getRole());
        savedUser.setPassword(user.getPassword());
        return userRepository.save(savedUser);
    }

}
