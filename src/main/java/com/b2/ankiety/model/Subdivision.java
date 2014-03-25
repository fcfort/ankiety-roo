package com.b2.ankiety.model;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import org.springframework.roo.addon.json.RooJson;

@RooJavaBean
@RooToString
@RooJson
@RooJpaActiveRecord(finders = { "findSubdivisionsByQuestions" })
public class Subdivision {

    /**
     */
    @NotNull
    private String title;

    /**
     */
    @ManyToOne
    private Division division;

    /**
     */
    @ManyToOne
    private Dictionary dictionary;

    /**
     */
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Question> questions = new HashSet<Question>();
}
