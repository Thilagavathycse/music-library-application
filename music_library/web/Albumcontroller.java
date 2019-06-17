package com.mrcooper.music_library.web;

import com.mrcooper.music_library.model.Album;
import com.mrcooper.music_library.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Albumcontroller {

    @Autowired
    private AlbumService albumService;

    @RequestMapping(value = "/albums", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Album> getAll() {
        final List<Album> allAlbums = albumService.getAllAlbums();
        return allAlbums;
    }

    @RequestMapping(value = "/album/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Album getAlbumById(@PathVariable Integer id) {
        //List<Artist> artistById= artistService.getArtistById(id);
        return albumService.getAlbumById(id);
    }

    @RequestMapping(value = "/albums", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void CreatedAlbum(@RequestBody Album album) {

        Album createdAlbum = albumService.createAlbum(album);

        final Optional<Object> o = Optional.ofNullable(Optional.ofNullable(createdAlbum)
                .map(al -> ResponseEntity.ok().body(al))
                .orElse(ResponseEntity.notFound().build()));
    }

    @RequestMapping(value = "/album", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createAlbum(@RequestBody Album album) {
        Album createdAlbum = albumService.createAlbum(album);
        final Optional<Object> o = Optional.ofNullable(Optional.ofNullable(createdAlbum)
                .map(a -> ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build()));
    }

    @RequestMapping(value = "/albums/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteAlbumById(@PathVariable int id) {
        albumService.deleteAlbumById(id);
        return ResponseEntity.noContent().header("message", "album deleted").build();
    }
}







