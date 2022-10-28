package io.kodlama.devs.business.abstracts;

import io.kodlama.devs.entities.concretes.ProgrammingLanguage;

import java.util.List;


public interface ProgrammingLanguageService {
    void add(ProgrammingLanguage programmingLanguage);
    void update(ProgrammingLanguage programmingLanguage);
    void delete(ProgrammingLanguage programmingLanguage);
    List<ProgrammingLanguage> getAll();
    ProgrammingLanguage getById(int id);
}
