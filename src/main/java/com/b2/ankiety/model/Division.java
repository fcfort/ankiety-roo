package com.b2.ankiety.model;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import org.springframework.roo.addon.json.RooJson;

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
}
