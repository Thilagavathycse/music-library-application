package com.mrcooper.music_library.web;

import com.mrcooper.music_library.model.Track;
import com.mrcooper.music_library.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api")
public class TrackController {
    @Autowired
    TrackService trackService;

    @RequestMapping(value = "/tracks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Track> getAll() {
        final List<Track> allTracks = trackService.getAllTracks();
        return allTracks;
    }

    @RequestMapping(value = "/tracks/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Track getTrackById(@PathVariable Integer id) {
        //List<Artist> artistById= artistService.getArtistById(id);
        return trackService.getTrackById(id);
    }

    @RequestMapping(value = "/tracks", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void setCreatedArtist(@RequestBody Track track) {

        Track createdTrack = trackService.createTrack(track);

        final Optional<Object> o = Optional.ofNullable(Optional.ofNullable(createdTrack)
                .map(t -> ResponseEntity.ok().body(t))
                .orElse(ResponseEntity.notFound().build()));
    }

    @RequestMapping(value = "/artist", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createTrack(@RequestBody Track track) {
        Track createdTrack = trackService.createTrack(track);
        final Optional<Object> o = Optional.ofNullable(Optional.ofNullable(createdTrack)
                .map(a -> ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build()));

    }
}

