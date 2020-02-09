package com.example.service;

import com.example.entity.PersonInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonInfoService {
    private int nextId = 1;
    private Map<Integer, PersonInfo> peopleDb = new HashMap<>();

    public PersonInfo get(int id) {
        return peopleDb.get(id);
    }

    public PersonInfo add(PersonInfo p) {
        p.setId(nextId++);
        peopleDb.put(p.getId(), p);
        return p;
    }

    public PersonInfo updatePersonInfo(int id, PersonInfo p) {
        p.setId(id);
        peopleDb.replace(id, p);
        return peopleDb.get(id);
    }

    public PersonInfo deletePersonInfo(int id) {
        return peopleDb.remove(id);
    }

    public List<PersonInfo> getPersonInfo() {
        return new ArrayList<>(peopleDb.values());
    }
}
