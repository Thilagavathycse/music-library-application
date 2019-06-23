package com.mrcooper.music_library.web;

import com.mrcooper.music_library.model.User;
import com.mrcooper.music_library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api")

public class UserController {

        @Autowired
        private UserService userService;

        @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        public List<User> getAll() {
            final List<User> allUsers = userService.getAllUsers();
            return allUsers;
        }

        @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        public User getUserById(@PathVariable Integer id) {
            //List<Artist> artistById= artistService.getArtistById(id);
            return userService.getUserById(id);
        }

        @RequestMapping(value = "/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
        public void CreatedUser(@RequestBody User user) {

            User createdUser = userService.createUser(user);

            final Optional<Object> o = Optional.ofNullable(Optional.ofNullable(createdUser)
                    .map(u -> ResponseEntity.ok().body(u))
                    .orElse(ResponseEntity.notFound().build()));
        }

        @RequestMapping(value = "/user", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
        public void createUser(@RequestBody User user) {
            User createdUser = userService.createUser(user);
            final Optional<Object> o = Optional.ofNullable(Optional.ofNullable(createdUser)
                    .map(u -> ResponseEntity.ok().body(u))
                    .orElse(ResponseEntity.notFound().build()));
        }

        @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Void> deleteUserById(@PathVariable int id) {
            userService.deleteUserById(id);
            return ResponseEntity.noContent().header("message", "user  deleted").build();
        }
    }







