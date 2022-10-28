package io.kodlama.devs.business.concretes;

import io.kodlama.devs.business.abstracts.ProgrammingLanguageService;
import io.kodlama.devs.business.rules.ProgrammingLanguageRules;
import io.kodlama.devs.dataaccess.abstracts.ProgrammingLanguageRepository;
import io.kodlama.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
    private final ProgrammingLanguageRepository _programmingLanguageRepository;
    private final ProgrammingLanguageRules _programmingLanguageRules;

    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository, ProgrammingLanguageRules programmingLanguageRules) {
        _programmingLanguageRules = programmingLanguageRules;
        _programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage) {
        try {
            _programmingLanguageRules.NameCannotBeRepeatedWhenAdded(programmingLanguage.getName());
            _programmingLanguageRules.NameCannotBeBlank(programmingLanguage.getName());
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        _programmingLanguageRepository.add(programmingLanguage);
    }

    @Override
    public void update(ProgrammingLanguage programmingLanguage) {
        try {
            _programmingLanguageRules.NameCannotBeRepeatedWhenUpdated(programmingLanguage.getId(), programmingLanguage.getName());
            _programmingLanguageRules.NameCannotBeBlank(programmingLanguage.getName());
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        _programmingLanguageRepository.update(programmingLanguage);
    }

    @Override
    public void delete(ProgrammingLanguage programmingLanguage) {
        _programmingLanguageRepository.delete(programmingLanguage);
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return _programmingLanguageRepository.getAll();
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        return _programmingLanguageRepository.getById(id);
    }
}
