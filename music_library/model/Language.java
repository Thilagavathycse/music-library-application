package com.mrcooper.music_library.model;

import javax.persistence.Id;

public class Language {
    @Id

    private int languageId;
    private String languageName;

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }
}
