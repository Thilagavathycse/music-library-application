package com.mrcooper.music_library.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Track {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int trackId;
    private String trackName;
    private int artistid;
    private Long genreid;
    private long albumid;
    private Long languageid;

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public int getArtistid() {
        return artistid;
    }

    public void setArtistid(int artistid) {
        this.artistid = artistid;
    }

    public Long getGenreid() {
        return genreid;
    }

    public void setGenreid(Long genreid) {
        this.genreid = genreid;
    }

    public long getAlbumid() {
        return albumid;
    }

    public void setAlbumid(long albumid) {
        this.albumid = albumid;
    }

    public Long getLanguageid() {
        return languageid;
    }

    public void setLanguageid(Long languageid) {
        this.languageid = languageid;
    }
}





