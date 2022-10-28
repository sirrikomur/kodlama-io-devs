package io.kodlama.devs.webapi.controllers;

import io.kodlama.devs.business.abstracts.ProgrammingLanguageService;
import io.kodlama.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programming-languages")
public class ProgrammingLanguagesController {
    private final ProgrammingLanguageService _programmingLanguageService;

    @Autowired
    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
        _programmingLanguageService = programmingLanguageService;
    }

    @PostMapping("/add")
    void add(@RequestBody ProgrammingLanguage programmingLanguage) {
        _programmingLanguageService.add(programmingLanguage);
    }

    @PostMapping("/update")
    void update(@RequestBody ProgrammingLanguage programmingLanguage) {
        _programmingLanguageService.update(programmingLanguage);
    }

    @PostMapping("/delete")
    void delete(@RequestBody ProgrammingLanguage programmingLanguage) {
        _programmingLanguageService.delete(programmingLanguage);
    }

    @GetMapping("/get-all")
    List<ProgrammingLanguage> getAll() {
        return _programmingLanguageService.getAll();
    }

    @GetMapping("/get-by-id")
    ProgrammingLanguage getById(@RequestParam int id) {
        return _programmingLanguageService.getById(id);
    }
}
