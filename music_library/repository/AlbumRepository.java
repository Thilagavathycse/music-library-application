package com.mrcooper.music_library.repository;

import com.mrcooper.music_library.model.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer> {
    Album deleteAlbumById(Integer id);
}
