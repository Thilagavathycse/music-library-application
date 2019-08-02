package com.musiclibrary.api.music.repository;

import com.musiclibrary.api.music.model.Language;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends CrudRepository<Language,Long> {
}
