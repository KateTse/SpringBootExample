package com.example.controller;

import com.example.entity.PersonInfo;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    private int nextId = 1;
    private Map<Integer, PersonInfo> peopleDb = new HashMap<>();

    @RequestMapping("/{id}")
    public PersonInfo getPersonInfo(@PathVariable int id) {
        return peopleDb.get(id);
    }

    @PostMapping
    public PersonInfo addPersonInfo(@RequestBody PersonInfo p) {
        p.setId(nextId++);
        peopleDb.put(p.getId(), p);
        return p;
    }

    @PutMapping("/{id}")
    public PersonInfo updatePersonInfo(@PathVariable int id, @RequestBody PersonInfo p) {
        p.setId(id);
        peopleDb.replace(id, p);
        return peopleDb.get(id);
    }

    @DeleteMapping("/{id}")
    public PersonInfo deletePersonInfo(@PathVariable int id) {
        return peopleDb.remove(id);
    }

    @GetMapping("/all")
    public List<PersonInfo> getPersonInfo() {
        return new ArrayList<>(peopleDb.values());
    }
}
