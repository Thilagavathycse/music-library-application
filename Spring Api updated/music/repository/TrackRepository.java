package com.musiclibrary.api.music.repository;

import com.musiclibrary.api.music.model.Track;
import org.springframework.data.repository.CrudRepository;

public interface TrackRepository  extends CrudRepository<Track,Long> {

}
