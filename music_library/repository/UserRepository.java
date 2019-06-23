package com.mrcooper.music_library.repository;

import com.mrcooper.music_library.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

}
