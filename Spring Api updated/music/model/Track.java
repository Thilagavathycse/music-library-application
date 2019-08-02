package com.musiclibrary.api.music.model;

import org.hibernate.annotations.ValueGenerationType;

import javax.persistence.*;

@Entity
public class Track {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long trackId;
    private String trackName;
//    private Long albumId;
  //  private Long artistId;
//    private Long genreId;
  //  private Long languageId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genreId")
    private Genre genre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "albumId")
    private Album album ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artistId")
    private Artist artist ;


    public Long getTrackId() {
        return trackId;
    }

    public void setTrackId(Long trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

}
