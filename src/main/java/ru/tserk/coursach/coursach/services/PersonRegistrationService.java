package ru.tserk.coursach.coursach.services;

import org.springframework.stereotype.Service;
import ru.tserk.coursach.coursach.models.Person;
import ru.tserk.coursach.coursach.repositories.PersonRepository;

import java.util.Optional;

@Service
public class PersonRegistrationService {
    private final PersonRepository personRepository;

    public PersonRegistrationService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Optional<Person> loadPersonByUsername(String username){
        return personRepository.findByUsername(username);
    }
}
