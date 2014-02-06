package com.b2.ankiety.model;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import org.springframework.roo.addon.json.RooJson;

@RooJavaBean
@RooToString
@RooJson
@RooJpaActiveRecord(finders = { "findPeopleByUsernameEquals" })
public class Person {

    /**
     */
    @NotNull
    @Column(unique = true)
    private String username;

    public static Person findPersonByUsernameOrCreate(String username) {
        TypedQuery<Person> people = findPeopleByUsernameEquals(username);
        Person p;
        if (people.getResultList().size() == 0) {
            p = new Person();
            p.setUsername(username);
            p.persist();
        } else {
            p = people.getSingleResult();
        }
        return p;
    }
}
