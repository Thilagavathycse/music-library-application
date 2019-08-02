package com.musiclibrary.api.music.repository;

import com.musiclibrary.api.music.model.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre,Long> {
}
