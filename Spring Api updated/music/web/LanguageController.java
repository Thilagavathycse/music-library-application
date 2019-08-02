package com.musiclibrary.api.music.web;

import com.musiclibrary.api.music.model.Language;
import com.musiclibrary.api.music.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api")
public class LanguageController {

    @Autowired
    LanguageService languageService;

    @RequestMapping(value = "/languages",method = RequestMethod.GET,produces = APPLICATION_JSON_VALUE)
    public List<Language> getAll()
    {
        return languageService.getAllLanguages();
    }

    @RequestMapping(value ="/languages/{id}",method = RequestMethod.GET,produces = APPLICATION_JSON_VALUE)
    public Language getLanguageById(@PathVariable("id") Long id){
        return (Language) languageService.getLanguageById(id);

    }

    @RequestMapping(value = "/languagess",method = RequestMethod.POST,produces = APPLICATION_JSON_VALUE)
    public  void createLanguage(@RequestBody Language language) {
        Language createdLanguage= languageService.createLanguage(language);
        final Optional<Object> o = Optional.ofNullable(Optional.ofNullable(createdLanguage)
                .map(a -> ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build()));
    }

    @RequestMapping(value="/languages",method=RequestMethod.PUT,produces=APPLICATION_JSON_VALUE)
    public  void CreateLanguage(@RequestBody Language language) {
       Language createdLanguage = languageService.createLanguage(language);
        final Optional<Object> o = Optional.ofNullable(Optional.ofNullable(createdLanguage)
                .map(a -> ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build()));
    }

    @RequestMapping(value="/languages/{id}" ,method = RequestMethod.DELETE,produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteLanguageById(@PathVariable("id") Long id) {
        languageService.deleteLanguageById(id);
        return ResponseEntity.noContent().header("message","language deleted").build();
    }

}
