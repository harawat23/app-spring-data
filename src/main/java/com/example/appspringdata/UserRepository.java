package com.example.appspringdata;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

interface UserRepository extends Neo4jRepository<User,String> {
    @Query("MATCH (u:User)"+"RETURN u LIMIT 20")
    Iterable<User> getSampleUsers();
}