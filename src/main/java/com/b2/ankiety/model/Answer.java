package com.b2.ankiety.model;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.persistence.ManyToOne;
import org.springframework.roo.addon.json.RooJson;

@RooJavaBean
@RooToString
@RooJson
@RooJpaActiveRecord(finders = { "findAnswersByQuestionAndPerson" })
public class Answer {

    /**
     */
    @NotNull
    private Boolean interested;

    /**
     */
    @ManyToOne
    private Person person;

    /**
     */
    @ManyToOne
    private Question question;

    /**
     */
    @ManyToOne
    private Choice choice;
}
