package com.mrcooper.music_library.services;

import com.mrcooper.music_library.model.Genre;
import com.mrcooper.music_library.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

  @Service
  public class GenreService{
        @Autowired
        private GenreRepository genreRepository;

        public Genre createGenre(Genre genre) {
            return genreRepository.save(genre);
        }

        public List<Genre> getAllGenres() {
            return (List<Genre>) genreRepository.findAll();
        }

        public Genre getGenreById(Integer id) {
          return genreRepository.findById(id).get();
        }

       // public Genre deleteGenreById(Integer id) {
           // return genreRepository.deleteGenreById(id);
        //}
    }



