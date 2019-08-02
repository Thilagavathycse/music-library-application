package com.musiclibrary.api.music.service;

import com.musiclibrary.api.music.model.Track;
import com.musiclibrary.api.music.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrackService {
    @Autowired
    private TrackRepository trackRepository;



    public List<Track> getAllTracks() {
        return (List<Track>) trackRepository.findAll();
    }

    public Track getTrackById(Long id) {
        return trackRepository.findById(id).get();

    }

        public  Track createTrack(Track track) {

            return trackRepository.save(track) ;
        }



    public Track deleteTrackById(Long id) {
        trackRepository.deleteById(id);
        return null;
    }
}
