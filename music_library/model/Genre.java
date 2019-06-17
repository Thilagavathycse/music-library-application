package com.mrcooper.music_library.model;

import javax.persistence.Id;

public class Genre {
    @Id
    private int genreid;
    private String genreName;

    public int getGenreid() {
        return genreid;
    }

    public void setGenreid(int genreid) {
        this.genreid = genreid;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
