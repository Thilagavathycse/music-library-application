package com.musiclibrary.api.music.web;

import com.musiclibrary.api.music.model.User;
import com.musiclibrary.api.music.repository.UserRepository;
import com.musiclibrary.api.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api")
public  class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/users",method = RequestMethod.GET,produces = APPLICATION_JSON_VALUE)
    public List<User> getAll(){
        return  userService.getAllUserss();
    }

    @RequestMapping(value ="/users/{id}",method = RequestMethod.GET,produces = APPLICATION_JSON_VALUE)
    public User getArtistById(@PathVariable("id") Long id){
        return (User) userService.getUserById(id);

    }


    @RequestMapping(value = "/users",method = RequestMethod.POST,produces = APPLICATION_JSON_VALUE)
    public  void createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        final Optional<Object> o = Optional.ofNullable(Optional.ofNullable(createdUser)
                .map(a -> ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build()));
    }

    @RequestMapping(value="/users",method=RequestMethod.PUT,produces=APPLICATION_JSON_VALUE)
    public  void CreateUser(@RequestBody User user) {
       User createdUser= userService.createUser(user);
        final Optional<Object> o = Optional.ofNullable(Optional.ofNullable(createdUser)
                .map(a -> ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build()));
    }

    @RequestMapping(value="/users/{id}" ,method = RequestMethod.DELETE,produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().header("message","user deleted").build();
    }


}
