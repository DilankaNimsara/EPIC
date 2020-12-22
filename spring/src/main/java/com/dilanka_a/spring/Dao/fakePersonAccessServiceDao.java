package com.dilanka_a.spring.Dao;

import com.dilanka_a.spring.Model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("FakeDao")
public class fakePersonAccessServiceDao implements PersonDao {
    private final List<Person> database = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        database.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectPeople() {
        return database;
    }

    @Override
    public Optional<Person> selectPersonByID(UUID id) {
        return database.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonByID(UUID id) {
        Optional<Person> personmaybe = selectPersonByID(id);
        if (personmaybe.isPresent()) {
            database.remove(personmaybe.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int updatepersonByID(UUID id, Person update) {
        return selectPersonByID(id).map(
                person1 -> {
                    int indexOfPersontableToUpdate = database.indexOf(person1);
                    if (indexOfPersontableToUpdate >= 0) {
                        database.set(indexOfPersontableToUpdate, new Person(id,update.getName()));
                        return 1;
                    }
                    return 0;
                }
        ).orElse(0);
    }
}
