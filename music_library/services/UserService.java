package com.mrcooper.music_library.services;

import com.mrcooper.music_library.model.User;
import com.mrcooper.music_library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


    @Service
    public class UserService {
        @Autowired
        private UserRepository userRepository;

        public User createUser(User user) {
            return userRepository.save(user);
        }

        public List<User> getAllUsers() {
            return (List<User>) userRepository.findAll();
        }

        public User getUserById(Integer id) {
            return userRepository.findById(id).get();
        }

        public void deleteUserById(Integer id) {
             userRepository.deleteById(id);
        }

    }
