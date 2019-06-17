package com.mrcooper.music_library.web;

import com.mrcooper.music_library.model.Language;
import com.mrcooper.music_library.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

    @RestController
    @RequestMapping("/api")
    public class LanguageController {

        @Autowired
        private LanguageService languageService;

        @RequestMapping(value = "/languages", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        public List<Language> getAll() {
            final List<Language> allLanguages = languageService.getAllLanguage();
            return allLanguages;
        }

        @RequestMapping(value = "/language/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        public Object getLanguageById(@PathVariable Integer id) {
            //List<Artist> artistById= artistService.getArtistById(id);
            return languageService.getLanguageById(id);
        }

        @RequestMapping(value = "/languages", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
        public void CreatedLanguage(@RequestBody Language language) {

            Object createdLanguage = languageService.createLanguage(language);

            final Optional<Object> o = Optional.ofNullable(Optional.ofNullable(createdLanguage)
                    .map(l -> ResponseEntity.ok().body(l))
                    .orElse(ResponseEntity.notFound().build()));
        }

        @RequestMapping(value = "/language", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
        public void  createLanguage(@RequestBody Language language) {
            Language createdLanguage = (Language) languageService.createLanguage(language);
            final Optional<Object> o = Optional.ofNullable(Optional.ofNullable(createdLanguage)
                    .map(l -> ResponseEntity.ok().body(l))
                    .orElse(ResponseEntity.notFound().build()));
             }

        @RequestMapping(value = "/language/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Void> deleteLanguageById(@PathVariable Integer id) {
             languageService.deleteLanguageById(id);
            return ResponseEntity.noContent().header("message", "language deleted").build();
        }

    }





