package com.dilanka_a.spring.Api;

import com.dilanka_a.spring.Model.Person;
import com.dilanka_a.spring.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPersonToList(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> selectAllP(){
        return personService.selectP();
    }

    @GetMapping(path = "{id}")
    public Person selectPersomnByID(@PathVariable("id") UUID id){
        return personService.getPersonByID(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public int deletePerson(@PathVariable("id") UUID id){
        return personService.deletePersonBYID(id);
    }

    @PutMapping(path = "{id}")
    public int updatePERson(@PathVariable("id") UUID id,@RequestBody Person person){
        return personService.updatePerson(id,person);
    }



}
