package com.musiclibrary.api.music.web;

import com.musiclibrary.api.music.model.Album;
import com.musiclibrary.api.music.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@RestController
@RequestMapping("/api")

public class AlbumController {

    @Autowired
    AlbumService albumService;

    @RequestMapping(value = "/albums",method = RequestMethod.GET,produces = APPLICATION_JSON_VALUE)
    public List<Album> getAll()
    {
        return albumService.getAllAlbums();
    }

    @RequestMapping(value ="/albums/{id}",method = RequestMethod.GET,produces = APPLICATION_JSON_VALUE)
    public Album getAlbumById(@PathVariable("id") Long id){
        return (Album) albumService.getAlbumById(id);
    }

    @RequestMapping(value = "/albums",method = RequestMethod.POST,produces = APPLICATION_JSON_VALUE)
    public void createAlbum(@RequestBody Album album) {
        Album createdAlbum = albumService.createAlbum(album);
        final Optional<Object> o = Optional.ofNullable(Optional.ofNullable(createdAlbum)
                .map(a -> ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build()));

    }
    @RequestMapping(value="/albums",method=RequestMethod.PUT,produces=APPLICATION_JSON_VALUE)
    public  void CreateAlbum(@RequestBody Album album) {
        Album createdAlbum = albumService.createAlbum(album);
        final Optional<Object> o = Optional.ofNullable(Optional.ofNullable(createdAlbum)
                .map(a -> ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build()));
    }

    @RequestMapping(value="/albums/{id}" ,method = RequestMethod.DELETE,produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteAlbumId(@PathVariable("id") Long id) {
        albumService.deleteAlbumById(id);
        return ResponseEntity.noContent().header("message","album deleted").build();
    }

}
