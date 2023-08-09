package com.it.utils.ldap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;


@Service
public class LdapServiceImpl implements LdapService {
    @Autowired
    private LdapTemplate ldapTemplate;
//    private final PersonRepository personRepository;
//
//    @Autowired
//    public LdapServiceImpl(LdapTemplate ldapTemplate, PersonRepository personRepository) {
//        this.ldapTemplate = ldapTemplate;
//        this.personRepository = personRepository;
//    }
//
//    @Override
//    public Iterable<Person> findAllPersons() {
//        return personRepository.findAll();
//    }
//
//    @Override
//    public Person findOnePerson(String attribute, String value) {
//        try {
//            return ldapTemplate.findOne(query().where(attribute).is(value), Person.class);
//        } catch (EmptyResultDataAccessException e) {
//            log.error("Found 0 result, error: {}", e.getMessage());
//        }
//        return null;
//    }

    @Override
    public boolean authenticate(String attribute, String username, String password) {


        return ldapTemplate.authenticate("dc=corp,dc=JABIL,dc=org","3554536","010803zl.@1234567");
//        return ldapTemplate.authenticate(
//                query().where(attribute).is(username),
//                password,
//                (dirContext, ldapEntryIdentification) ->
//                        ldapTemplate.findOne(query().where(attribute).is(username), LdapUser.class));
    }

}
