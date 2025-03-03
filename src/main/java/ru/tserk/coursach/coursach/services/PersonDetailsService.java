package ru.tserk.coursach.coursach.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.tserk.coursach.coursach.models.Person;
import ru.tserk.coursach.coursach.repositories.PersonRepository;
import ru.tserk.coursach.coursach.security.PersonDetails;

import java.util.Optional;

@Service
// add @Transactional
public class PersonDetailsService implements UserDetailsService {

    private final PersonRepository personRepository;

    public PersonDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = personRepository.findByUsername(username);

        if(person.isEmpty()){
            throw new UsernameNotFoundException("Пользователь не найден");
        }

    return new PersonDetails(person.get());

    }
}
