package com.example.appspringdata;

import org.springframework.data.neo4j.repository.Neo4jRepository;

interface PersonRepository extends Neo4jRepository<Person,String>{
}
