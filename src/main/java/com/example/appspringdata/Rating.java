package com.example.appspringdata;

import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class Rating {
    @RelationshipId
    private String id;
    
    private Float rating;

    @TargetNode 
    private User user;

    public Rating(User user,Float rating){
        this.user=user;
        this.rating=rating;
    }

    public Float getRating(){
        return this.rating;
    }

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id=id;
    }

    public User getUser(){
        return this.user;
    }
}