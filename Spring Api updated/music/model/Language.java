package com.musiclibrary.api.music.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Language {
    @Id
    private Long languageId;
    private String languageName;

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }
}
