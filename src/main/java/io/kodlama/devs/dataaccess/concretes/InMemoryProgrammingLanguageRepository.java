package io.kodlama.devs.dataaccess.concretes;

import io.kodlama.devs.dataaccess.abstracts.ProgrammingLanguageRepository;
import io.kodlama.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {
    private List<ProgrammingLanguage> _programmingLanguages;

    public InMemoryProgrammingLanguageRepository() {
        _programmingLanguages = new ArrayList<ProgrammingLanguage>();
        _programmingLanguages.add(new ProgrammingLanguage(1, "C#"));
        _programmingLanguages.add(new ProgrammingLanguage(2, "Java"));
        _programmingLanguages.add(new ProgrammingLanguage(3, "Python"));
    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage) {
        _programmingLanguages.add(programmingLanguage);
    }

    @Override
    public void update(ProgrammingLanguage programmingLanguage) {
        for (ProgrammingLanguage languageToUpdate : _programmingLanguages) {
            if (languageToUpdate.getId() == programmingLanguage.getId()) {
                int index = _programmingLanguages.indexOf(languageToUpdate);
                _programmingLanguages.set(index, programmingLanguage);
                return;
            }
        }
    }

    @Override
    public void delete(ProgrammingLanguage programmingLanguage) {
        for (ProgrammingLanguage languageToDelete : _programmingLanguages) {
            if (languageToDelete.getId() == programmingLanguage.getId()) {
                _programmingLanguages.remove(languageToDelete);
                return;
            }
        }
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return _programmingLanguages;
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        return _programmingLanguages.get(id);
    }
}
