package com.musiclibrary.api.music.web;

import com.musiclibrary.api.music.model.Artist;
import com.musiclibrary.api.music.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api")
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @RequestMapping(value = "/artists",method = RequestMethod.GET,produces = APPLICATION_JSON_VALUE)
    public List<Artist> getAll()
    {
    return artistService.getAllArtists();
    }

    @RequestMapping(value ="/artists/{id}",method = RequestMethod.GET,produces = APPLICATION_JSON_VALUE)
    public Artist getArtistById(@PathVariable("id") Long id){
        return (Artist) artistService.getArtistById(id);

    }

    @RequestMapping(value = "/artists",method = RequestMethod.POST,produces = APPLICATION_JSON_VALUE)
    public  void createArtist(@RequestBody Artist artist) {
        Artist createdArtist = artistService.createArtist(artist);
        final Optional<Object> o = Optional.ofNullable(Optional.ofNullable(createdArtist)
                .map(a -> ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build()));
    }

    @RequestMapping(value="/artists",method=RequestMethod.PUT,produces=APPLICATION_JSON_VALUE)
    public  void CreateArtist(@RequestBody Artist artist) {
        Artist createdArtist = artistService.createArtist(artist);
        final Optional<Object> o = Optional.ofNullable(Optional.ofNullable(createdArtist)
                .map(a -> ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build()));
    }

    @RequestMapping(value="/artists/{id}" ,method = RequestMethod.DELETE,produces = APPLICATION_JSON_VALUE)
           public ResponseEntity<Object> deleteArtistById(@PathVariable("id") Long id) {
      artistService.deleteArtistById(id);
      return ResponseEntity.noContent().header("message","artist deleted").build();
   }

}
