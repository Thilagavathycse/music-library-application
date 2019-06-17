package com.mrcooper.music_library.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Album {

    @Id
    private int albumId;
    private String albumName;

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
}
