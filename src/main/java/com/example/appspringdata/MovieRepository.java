package com.example.appspringdata;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import java.util.Optional;

interface MovieRepository extends Neo4jRepository<Movie, String> {
    @Query("MATCH (m:Movie {movieId:$id}) " +
           "RETURN m")
    Optional<Movie> findById(String id);

    @Query("MATCH (m:Movie)<-[r:ACTED_IN]-(p:Person) " +
           "RETURN m LIMIT 20")
    Iterable<Movie> findMoviesSubset();

    @Query("MATCH (m:Movie)<-[r:ACTED_IN]-(p:Person {name:$name})" + "RETURN m,collect(r),p LIMIT 20;")
    Iterable<Movie> findMoviesByPerson(String name);

    @Query("MATCH (m:Movie {movieId:$movieId})" + "SET m.imdbVotes=coalesce(m.imdbVotes+1,1)" + "RETURN m")
    Iterable<Movie> increaseVotes(String movieId);

    Iterable<MovieProjection> findAllMovieProjectionsBy();
}