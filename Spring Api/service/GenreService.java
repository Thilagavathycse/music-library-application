package com.musiclibrary.api.music.service;

import com.musiclibrary.api.music.model.Genre;
import com.musiclibrary.api.music.model.Genre;
import com.musiclibrary.api.music.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> getAllGenre() {
        return (List<Genre>) genreRepository.findAll();
    }

    public Genre getGenreById(Long id) {
        return genreRepository.findById(id).get();
    }

    public Genre createGenre(Genre genre) { return genreRepository.save(genre) ;
    }


    public Genre deleteGenreById(Long id) {
        genreRepository.deleteById(id);
        return null;
    }
}
