package com.musiclibrary.api.music.web;


import com.musiclibrary.api.music.model.Genre;
import com.musiclibrary.api.music.model.Track;
import com.musiclibrary.api.music.service.GenreService;
import com.musiclibrary.api.music.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api")
public class GenreController {
    @Autowired
    GenreService genreService;

   @RequestMapping(value = ("/genres"),method = RequestMethod.GET,produces = APPLICATION_JSON_VALUE)
    public List<Genre> getAll()
   {
       return  genreService.getAllGenre();
   }

    @RequestMapping(value ="/genres/{id}",method = RequestMethod.GET,produces = APPLICATION_JSON_VALUE)
    public Genre getGenreById(@PathVariable("id") Long id){
        return (Genre) genreService.getGenreById(id);
    }

    @RequestMapping(value = "/genres",method = RequestMethod.POST,produces = APPLICATION_JSON_VALUE)
    public void createGenre(@RequestBody Genre genre) {
       Genre createdGenre = genreService.createGenre(genre);
        final Optional<Object> o = Optional.ofNullable(Optional.ofNullable(createdGenre)
                .map(a -> ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build()));

    }
    @RequestMapping(value="/genres",method=RequestMethod.PUT,produces=APPLICATION_JSON_VALUE)
    public  void CreateGenre(@RequestBody Genre genre) {
       Genre createdGenre = genreService.createGenre(genre);
        final Optional<Object> o = Optional.ofNullable(Optional.ofNullable(createdGenre)
                .map(a -> ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build()));
    }

    @RequestMapping(value="/genres/{id}" ,method = RequestMethod.DELETE,produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteGenreId(@PathVariable("id") Long id) {
        genreService.deleteGenreById(id);
        return ResponseEntity.noContent().header("message","album deleted").build();
    }
   /* @RequestMapping(value = "/genres/by-track/{id}",method = RequestMethod.GET,produces =APPLICATION_JSON_VALUE )
    public Optional<Genre> getGenreByTrackId(@PathVariable ("id") Long TrackId ){
       return genreService.findByTrackId(TrackId);
    }/*
   /*@RequestMapping(value = "/{genreId}/track", method = RequestMethod.GET, consumes = APPLICATION_JSON_VALUE)
    public Genre create(@PathVariable(value = "genreId") Long id, @RequestBody Track track) {
        return genreService.getTrackByGenreId(id, track);
    }*/

}
