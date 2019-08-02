package com.musiclibrary.api.music.service;


import com.musiclibrary.api.music.model.Album;
import com.musiclibrary.api.music.model.Artist;
import com.musiclibrary.api.music.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> getAllAlbums() {
        return (List<Album>) albumRepository.findAll();
    }


    public Album createAlbum(Album album) {
        return albumRepository.save(album);
    }

    public Album getAlbumById(Long id) {
        return albumRepository.findById(id).get();
    }

    public Album deleteAlbumById(Long id) {
       albumRepository.deleteById(id);
        return null;
    }

}
