package io.kodlama.devs.business.rules;

import io.kodlama.devs.dataaccess.abstracts.ProgrammingLanguageRepository;
import io.kodlama.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Service;

@Service
public class ProgrammingLanguageRules {
    private final ProgrammingLanguageRepository _programmingLanguageRepository;

    public ProgrammingLanguageRules(ProgrammingLanguageRepository programmingLanguageRepository) {
        _programmingLanguageRepository = programmingLanguageRepository;
    }

    public void NameCannotBeRepeatedWhenAdded(String name) throws Exception {
        for (ProgrammingLanguage language : _programmingLanguageRepository.getAll()) {
            if (language.getName().equals(name)) {
                throw new Exception("Name cannot be repeated!");
            }
        }
    }

    public void NameCannotBeRepeatedWhenUpdated(int id, String name) throws Exception {
        for (ProgrammingLanguage language : _programmingLanguageRepository.getAll()) {
            if (language.getName().equals(name) && language.getId() != id) {
                throw new Exception("Name cannot be repeated!");
            }
        }
    }

    public void NameCannotBeBlank(String name) throws Exception {
        if (name.isBlank()) {
            throw new Exception("Name cannot be blank!");
        }
    }
}
