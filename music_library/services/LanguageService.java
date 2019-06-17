package com.mrcooper.music_library.services;

import com.mrcooper.music_library.model.Language;
import com.mrcooper.music_library.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LanguageService {
        @Autowired
        private LanguageRepository languageRepository;

        public Object createLanguage(Language language) {
            return languageRepository.save(language);
        }

          public Object getLanguageById(Integer id) {
        return languageRepository.findById(id).get();
    }

        public Language deleteLanguageById(Integer id) {
            return languageRepository.deleteLanguageById(id);
        }

    public List<Language> getAllLanguage() {
        return (List<Language>) languageRepository.findAll();

    }



}
