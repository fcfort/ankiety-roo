// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.b2.ankiety.model;

import com.b2.ankiety.model.Subdivision;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

privileged aspect Subdivision_Roo_Jpa_Entity {
    
    declare @type: Subdivision: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Subdivision.id;
    
    @Version
    @Column(name = "version")
    private Integer Subdivision.version;
    
    public Long Subdivision.getId() {
        return this.id;
    }
    
    public void Subdivision.setId(Long id) {
        this.id = id;
    }
    
    public Integer Subdivision.getVersion() {
        return this.version;
    }
    
    public void Subdivision.setVersion(Integer version) {
        this.version = version;
    }
    
}
