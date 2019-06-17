package com.mrcooper.music_library.services;

import com.mrcooper.music_library.model.Album;
import com.mrcooper.music_library.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


  @Service
  public class AlbumService {
        @Autowired
        private AlbumRepository albumRepository;

        public Album createAlbum(Album album) {
            return albumRepository.save(album);
        }

        public List<Album> getAllAlbums() {
            return (List<Album>) albumRepository.findAll();
        }

        public Album getAlbumById(Integer id) {
            return albumRepository.findById(id).get();
        }

       public Album deleteAlbumById(Integer id) {
            return albumRepository.deleteAlbumById(id);
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


