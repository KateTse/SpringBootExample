package com.example.controller;

import com.example.controller.exception.PersonInfoNotFoundException;
import com.example.entity.PersonInfo;
import com.example.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonInfoService personInfoService;

    @RequestMapping("/{id}")
    public PersonInfo getPersonInfo(@PathVariable int id) {
        PersonInfo p = personInfoService.get(id);
        if (p == null) {
            throw new PersonInfoNotFoundException();
        }
        return p;

    }

    @PostMapping
    public PersonInfo addPersonInfo(@RequestBody PersonInfo p) {
        return personInfoService.add(p);
    }

    @PutMapping("/{id}")
    public PersonInfo updatePersonInfo(@PathVariable int id, @RequestBody PersonInfo p) {
        p = personInfoService.updatePersonInfo(id, p);
        if (p == null) {
            throw new PersonInfoNotFoundException();
        }
        return p;
    }

    @DeleteMapping("/{id}")
    public PersonInfo deletePersonInfo(@PathVariable int id) {
        PersonInfo p = personInfoService.deletePersonInfo(id);
        if (p == null) {
            throw new PersonInfoNotFoundException();
        }
        return p;
    }

    @GetMapping("/all")
    public List<PersonInfo> getPersonInfo() {
        return personInfoService.getPersonInfo();
    }
}
