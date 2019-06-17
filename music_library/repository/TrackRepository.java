package com.mrcooper.music_library.repository;

import com.mrcooper.music_library.model.Artist;
import com.mrcooper.music_library.model.Track;
import org.springframework.data.repository.CrudRepository;

public interface TrackRepository extends CrudRepository<Track,Integer> {
    Artist deleteTrackById(Integer id);
}
