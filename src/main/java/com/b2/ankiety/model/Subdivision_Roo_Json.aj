// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.b2.ankiety.model;

import com.b2.ankiety.model.Subdivision;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect Subdivision_Roo_Json {
    
    public String Subdivision.toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }
    
    public String Subdivision.toJson(String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(this);
    }
    
    public static Subdivision Subdivision.fromJsonToSubdivision(String json) {
        return new JSONDeserializer<Subdivision>().use(null, Subdivision.class).deserialize(json);
    }
    
    public static String Subdivision.toJsonArray(Collection<Subdivision> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }
    
    public static String Subdivision.toJsonArray(Collection<Subdivision> collection, String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<Subdivision> Subdivision.fromJsonArrayToSubdivisions(String json) {
        return new JSONDeserializer<List<Subdivision>>().use(null, ArrayList.class).use("values", Subdivision.class).deserialize(json);
    }
    
}