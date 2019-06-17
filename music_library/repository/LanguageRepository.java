package com.mrcooper.music_library.repository;

import com.mrcooper.music_library.model.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Integer> {

    Language deleteLanguageById(Integer id);

}
