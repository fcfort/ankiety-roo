// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.b2.ankiety.model;

import com.b2.ankiety.model.Person;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

privileged aspect Person_Roo_Finder {
    
    public static TypedQuery<Person> Person.findPeopleByUsernameEquals(String username) {
        if (username == null || username.length() == 0) throw new IllegalArgumentException("The username argument is required");
        EntityManager em = Person.entityManager();
        TypedQuery<Person> q = em.createQuery("SELECT o FROM Person AS o WHERE o.username = :username", Person.class);
        q.setParameter("username", username);
        return q;
    }
    
}
