package com.musiclibrary.api.music.repository;

import com.musiclibrary.api.music.model.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album,Long> {
}
