package com.mrcooper.music_library.web;

import com.mrcooper.music_library.model.Genre;
import com.mrcooper.music_library.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api")
public class GenreController {

        @Autowired
        GenreService genreService;

        @RequestMapping(value = "/genres", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        public List<Genre> getAll() {
            final List<Genre> allGenres= genreService.getAllGenres();
            return allGenres;
        }

        @RequestMapping(value = "/genres/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        public Genre getGenreById(@PathVariable Integer id) {
            //List<Artist> artistById= artistService.getArtistById(id);
            return genreService.getGenreById(id);
        }

        @RequestMapping(value = "/genres", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
        public void setCreatedGenre(@RequestBody Genre genre) {

            Genre createdGenre = genreService.createGenre(genre);

            final Optional<Object> o = Optional.ofNullable(Optional.ofNullable(createdGenre)
                    .map(g -> ResponseEntity.ok().body(g))
                    .orElse(ResponseEntity.notFound().build()));
        }

        @RequestMapping(value = "/service", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
        public void createGenre(@RequestBody Genre genre) {
            Genre createdGenre = genreService.createGenre(genre);
            final Optional<Object> o = Optional.ofNullable(Optional.ofNullable(createdGenre)
                    .map(a -> ResponseEntity.ok().body(a))
                    .orElse(ResponseEntity.notFound().build()));
        }

       // @RequestMapping(value = "/genres/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
        //public ResponseEntity<Void> deleteGenreById(@PathVariable int id) {
           // genreService.deleteGenreById(id);
            //return ResponseEntity.noContent().header("message", "genre deleted").build();
       // }

        }





