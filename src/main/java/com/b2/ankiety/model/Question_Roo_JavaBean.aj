// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.b2.ankiety.model;

import com.b2.ankiety.model.Answer;
import com.b2.ankiety.model.Question;
import com.b2.ankiety.model.Subdivision;

privileged aspect Question_Roo_JavaBean {
    
    public String Question.getBody() {
        return this.body;
    }
    
    public void Question.setBody(String body) {
        this.body = body;
    }
    
    public Answer Question.getTransientAnswer() {
        return this.transientAnswer;
    }
    
    public void Question.setTransientAnswer(Answer transientAnswer) {
        this.transientAnswer = transientAnswer;
    }
    
    public Subdivision Question.getSubdivision() {
        return this.subdivision;
    }
    
    public void Question.setSubdivision(Subdivision subdivision) {
        this.subdivision = subdivision;
    }
    
}
