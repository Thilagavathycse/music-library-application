package com.mrcooper.music_library.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Artist {
   @Id
   private int artistid;
   private String artistname;

   public int getArtistid() {
      return artistid;
   }

   public void setArtistid(int artistid) {
      this.artistid = artistid;
   }

   public String getArtistname() {
      return artistname;
   }

   public void setArtistname(String artistname) {

      this.artistname = artistname;
   }
}



