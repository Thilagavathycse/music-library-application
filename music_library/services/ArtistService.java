package com.mrcooper.music_library.services;

import com.mrcooper.music_library.model.Artist;
import com.mrcooper.music_library.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    public  Artist createArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public List<Artist> getAllArtists() {
        return (List<Artist>) artistRepository.findAll();
    }

    public Artist getArtistById(Integer id) {
        return artistRepository.findById(id).get();
    }

    public Artist deleteArtistById(Integer id) {
       return artistRepository.deleteArtistById(id);
    }
    /*
    @Autowired
    protected list  getAllArtists() {
        return Artists;
    }

    private void findAll() {
    }

     */
}
