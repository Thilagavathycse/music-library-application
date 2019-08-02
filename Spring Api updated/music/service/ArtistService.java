package com.musiclibrary.api.music.service;

import com.musiclibrary.api.music.model.Artist;
import com.musiclibrary.api.music.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    public List<Artist> getAllArtists() {
        return (List<Artist>) artistRepository.findAll();
    }

    public Artist getArtistById(Long id) {
        return artistRepository.findById(id).get();
    }

    public Artist createArtist(Artist artist) { return artistRepository.save(artist) ;
    }


    public Artist deleteArtistById(Long id) {
         artistRepository.deleteById(id);
         return null;
    }
}
