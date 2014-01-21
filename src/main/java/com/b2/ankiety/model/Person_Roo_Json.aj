// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.b2.ankiety.model;

import com.b2.ankiety.model.Person;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect Person_Roo_Json {
    
    public String Person.toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }
    
    public String Person.toJson(String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(this);
    }
    
    public static Person Person.fromJsonToPerson(String json) {
        return new JSONDeserializer<Person>().use(null, Person.class).deserialize(json);
    }
    
    public static String Person.toJsonArray(Collection<Person> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }
    
    public static String Person.toJsonArray(Collection<Person> collection, String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<Person> Person.fromJsonArrayToPeople(String json) {
        return new JSONDeserializer<List<Person>>().use(null, ArrayList.class).use("values", Person.class).deserialize(json);
    }
    
}
