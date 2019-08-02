package com.musiclibrary.api.music.service;

import com.musiclibrary.api.music.model.Language;
import com.musiclibrary.api.music.model.Language;
import com.musiclibrary.api.music.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LanguageService {
    @Autowired
    private LanguageRepository languageRepository;


    public List<Language> getAllLanguages() {
        return (List<Language>)languageRepository.findAll();
    }

    public Language getLanguageById(Long id) {
        return languageRepository.findById(id).get();
    }

    public Language createLanguage(Language language) { return languageRepository.save(language) ;
    }


    public Language deleteLanguageById(Long id) {
        languageRepository.deleteById(id);
        return null;
    }

}
