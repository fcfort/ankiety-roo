package com.b2.ankiety.model;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooJson
public class Question {

    /**
     */
    @NotNull
    private String body;

    @Transient
    private Answer transientAnswer;    
    
    /**
     */
    @ManyToOne
    private Subdivision subdivision;
}
