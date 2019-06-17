package com.mrcooper.music_library.services;

import com.mrcooper.music_library.model.Artist;
import com.mrcooper.music_library.model.Track;
import com.mrcooper.music_library.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrackService {
    @Autowired
    private TrackRepository trackRepository;

    public Track createTrack(Track track) {
        return trackRepository.save(track);
    }

    public List<Track> getAllTracks() {
        return (List<Track>) trackRepository.findAll();
    }

    public Track getTrackById(Integer id) {
        return trackRepository.findById(id).get();
    }

    public Artist deleteTrackById(Integer id) {
        return trackRepository.deleteTrackById(id);
    }

}
