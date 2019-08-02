package com.musiclibrary.api.music.repository;

import com.musiclibrary.api.music.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUserNameAndPassword(String userName, String password);
}
