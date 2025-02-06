package ru.tserk.coursach.coursach.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.tserk.coursach.coursach.models.Person;
import ru.tserk.coursach.coursach.services.PersonRegistrationService;

@Component
public class PersonValidator implements Validator {

    private final PersonRegistrationService personRegistrationService;

    public PersonValidator(PersonRegistrationService personRegistrationService) {
        this.personRegistrationService = personRegistrationService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person)o;

        if(personRegistrationService.loadPersonByUsername(person.getUsername()).isPresent()){
            errors.rejectValue("username", "", "Пользователь с таким именем уже существует");
        }else {
            return;
        }
    }
}
