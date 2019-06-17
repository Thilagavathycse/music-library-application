package com.mrcooper.music_library.web;

import com.mrcooper.music_library.model.Artist;
import com.mrcooper.music_library.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ArtistController {
    @Autowired
    ArtistService artistService;

    @RequestMapping(value = "/artists", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Artist> getAll() {
        final List<Artist> allArtists = artistService.getAllArtists();
        return allArtists;
    }

    @RequestMapping(value = "/artists/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Artist getArtistById(@PathVariable Integer id) {
        //List<Artist> artistById= artistService.getArtistById(id);
        return artistService.getArtistById(id);
    }

    @RequestMapping(value = "/artists", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void setCreatedArtist(@RequestBody Artist artist) {

        Artist createdArtist = artistService.createArtist(artist);

        final Optional <Object> o = Optional.ofNullable(Optional.ofNullable(createdArtist)
                .map(a -> ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build()));
    }

    @RequestMapping(value = "/artist", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createArtist(@RequestBody Artist artist) {
        Artist createdArtist = artistService.createArtist(artist);
        final Optional<Object> o = Optional.ofNullable(Optional.ofNullable(createdArtist)
                .map(a -> ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build()));
    }

    @RequestMapping(value = "/artists/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteArtistById(@PathVariable int id) {
                   artistService.deleteArtistById(id);
            return ResponseEntity.noContent().header("message", "artist deleted").build();
        }
    }






