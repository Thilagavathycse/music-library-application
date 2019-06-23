package com.mrcooper.music_library.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class User {
    @Id
     private int userId;
     private String UserName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
