package com.mrcooper.music_library.repository;

import com.mrcooper.music_library.model.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public  interface ArtistRepository extends CrudRepository <Artist,Integer> {

    Artist deleteArtistById(Integer id);
}
