package com.dilanka_a.spring.Service;

import com.dilanka_a.spring.Dao.PersonDao;
import com.dilanka_a.spring.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("FakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> selectP() {
        return personDao.selectPeople();
    }

    public Optional<Person> getPersonByID(UUID id){
        return personDao.selectPersonByID(id);
    }
    public int deletePersonBYID(UUID id){
        return personDao.deletePersonByID(id);
    }

    public int updatePerson(UUID id, Person person){
        return personDao.updatepersonByID(id,person);
    }

}
