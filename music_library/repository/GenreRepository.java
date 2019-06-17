package com.mrcooper.music_library.repository;

import com.mrcooper.music_library.model.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends CrudRepository<Genre,Integer> {
    //Genre deleteGenreById(Integer id);
}
