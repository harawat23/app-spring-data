package com.example.appspringdata;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

@Node
public class Genre {
    @Id
    @GeneratedValue(generatorClass = UUIDStringGenerator.class)
    
    private String name;

    public String getName() {
        return name;
    }

}