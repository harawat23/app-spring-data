package com.example.appspringdata;

import java.util.Optional;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    Iterable<Movie> getAllMovies() {
        return movieRepository.findMoviesSubset();
    }

    @GetMapping("/{id}")
    Optional<Movie> getMovieById(@PathVariable String id) {
        return movieRepository.findById(id);      
    }

    @PostMapping("/save")
    public Movie postMethodName(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @DeleteMapping("/delete")
    void delete(@RequestParam String movieId) {
        movieRepository.deleteById(movieId);
        System.out.println("Deleted movie with movieId: " + movieId);
    }

    @GetMapping("/person")
    public Iterable<Movie> getMoviesByPerson(@RequestParam String name) {
        return movieRepository.findMoviesByPerson(name);
    }

    @PutMapping("updateVotes")
    public Iterable<Movie> addVoteToMovie(@RequestParam String movieId) {
        return movieRepository.increaseVotes(movieId);
    }
    
    @GetMapping("/movielist")
    public Iterable<MovieProjection> getMovieProjection() {
        return movieRepository.findAllMovieProjectionsBy();
    }
}