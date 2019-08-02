package com.musiclibrary.api.music.service;

import com.musiclibrary.api.music.model.User;
import com.musiclibrary.api.music.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired

    private UserRepository userRepository;



    public User getUserById(Long id) {
        return getUserById(id);
    }


    public User deleteUserById(Long id) {
        userRepository.deleteById(id);
        return null;
    }

    public List<User> getAllUserss() {
        return (List<User>) userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
