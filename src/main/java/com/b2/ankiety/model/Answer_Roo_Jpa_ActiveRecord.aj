// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.b2.ankiety.model;

import com.b2.ankiety.model.Answer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Answer_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Answer.entityManager;
    
    public static final EntityManager Answer.entityManager() {
        EntityManager em = new Answer().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Answer.countAnswers() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Answer o", Long.class).getSingleResult();
    }
    
    public static List<Answer> Answer.findAllAnswers() {
        return entityManager().createQuery("SELECT o FROM Answer o", Answer.class).getResultList();
    }
    
    public static Answer Answer.findAnswer(Long id) {
        if (id == null) return null;
        return entityManager().find(Answer.class, id);
    }
    
    public static List<Answer> Answer.findAnswerEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Answer o", Answer.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Answer.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Answer.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Answer attached = Answer.findAnswer(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Answer.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Answer.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Answer Answer.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Answer merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
