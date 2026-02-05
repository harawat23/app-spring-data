package com.example.appspringdata;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class User {
    @Id
    private String userId;
    
    private String name;

    public User(String userId,String name){
        this.userId=userId;
        this.name=name;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}