package com.musiclibrary.api.music.web;

import com.musiclibrary.api.music.model.Track;
import com.musiclibrary.api.music.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api")

public class TrackController {
    @Autowired
    TrackService trackService;

    @RequestMapping(value = "/tracks",method = RequestMethod.GET,produces = APPLICATION_JSON_VALUE)
    public List<Track> getAll()
    {
        return trackService.getAllTracks();
    }

    @RequestMapping(value ="/tracks/{id}",method = RequestMethod.GET,produces = APPLICATION_JSON_VALUE)
    public  Track getTrackById(@PathVariable("id") Long id){
        return (Track) trackService.getTrackById(id);

    }

    @RequestMapping(value = "/tracks",method = RequestMethod.POST,produces = APPLICATION_JSON_VALUE)
    public  void create(@RequestBody Track track) {
        Track createdTrack = trackService.createTrack(track);
        final Optional<Object> o = Optional.ofNullable(Optional.ofNullable(createdTrack)
                .map(a -> ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build()));
    }

    @RequestMapping(value="/tracks",method=RequestMethod.PUT,produces=APPLICATION_JSON_VALUE)
    public  void CreateTrack(@RequestBody Track track) {
        Track createdTrack= trackService.createTrack(track);
        final Optional<Object> o = Optional.ofNullable(Optional.ofNullable(createdTrack)
                .map(a -> ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build()));
    }

    @RequestMapping(value="tracks/{id}" ,method = RequestMethod.DELETE,produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteTrackById(@PathVariable("id") Long id) {
        trackService.deleteTrackById(id);
        return ResponseEntity.noContent().header("message","user deleted").build();
    }



}
