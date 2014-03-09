package com.b2.ankiety.model;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooJson
public class Division {

    /**
     */
    @NotNull
    private String title;

    /**
     */
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Subdivision> subdivisions = new HashSet<Subdivision>();
    
    public static List<Division> findAllDivisionsOrderById() {
        return entityManager().createQuery("SELECT o FROM Division o ORDER BY id", Division.class).getResultList();
    }    
    
}
