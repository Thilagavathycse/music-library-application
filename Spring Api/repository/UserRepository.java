package com.musiclibrary.api.music.repository;

import com.musiclibrary.api.music.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
