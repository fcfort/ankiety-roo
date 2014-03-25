package com.b2.ankiety.model;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

import com.b2.ankiety.AnswerSearchCriteria;

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
    
    public static List<Person> findPersonsByCriteria(Set<AnswerSearchCriteria> crits) {
    	StringBuffer sb = new StringBuffer();
    	
    	sb.append("select p from Person p where id in (");
    	sb.append("select a.id from Answer a ");
    	sb.append("where "); 

    	Set<String> s = new HashSet<String>();
    	for (AnswerSearchCriteria asc : crits) {
    		s.add("(a.choice=" + asc.getChoiceId() + " and a.question=" + asc.getQuestionId() + ")");
    	}
    	sb.append(StringUtils.join(s, " or "));
    	
    	sb.append(" group by person having count(*) = " + crits.size());
    	sb.append(" )");

    	return entityManager().createQuery(sb.toString()).getResultList();
    }
    
    
}
