package com.example.appspringdata;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import java.util.List;

@Node
public class Movie {
    @Id
    private String movieId;

    private String title;
    private String plot;
    private String poster;
    private String url;
    private String imdbId;
    private String tmdbId;
    private String released;

    private Long year;
    private Long runtime;
    private Long budget;
    private Long revenue;
    private Long imdbVotes;

    private Double imdbRating;

    private String[] languages;
    private String[] countries;

    @Relationship(value = "ACTED_IN", direction = Relationship.Direction.INCOMING)
    private List<Role> actors;

    @Relationship(value="RATED" , direction=Relationship.Direction.INCOMING)
    private List<Rating> ratings;

    @Relationship(value = "IN_GENRE", direction = Relationship.Direction.OUTGOING)
    private List<Genre> genres;

    public Movie(String movieId, String title, String plot, String poster, String url, String imdbId, String tmdbId,
                 String released, Long year, Long runtime, Long budget, Long revenue, Long imdbVotes, Double imdbRating,
                 String[] languages, String[] countries) {
        this.movieId = movieId;
        this.title = title;
        this.plot = plot;
        this.poster = poster;
        this.url = url;
        this.imdbId = imdbId;
        this.tmdbId = tmdbId;
        this.released = released;
        this.year = year;
        this.runtime = runtime;
        this.budget = budget;
        this.revenue = revenue;
        this.imdbVotes = imdbVotes;
        this.imdbRating = imdbRating;
        this.languages = languages;
        this.countries = countries;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getPlot() {
        return plot;
    }

    public String getPoster() {
        return poster;
    }

    public String getUrl() {
        return url;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getTmdbId() {
        return tmdbId;
    }

    public String getReleased() {
        return released;
    }

    public Long getYear() {
        return year;
    }

    public Long getRuntime() {
        return runtime;
    }

    public Long getBudget() {
        return budget;
    }

    public Long getRevenue() {
        return revenue;
    }

    public Long getImdbVotes() {
        return imdbVotes;
    }

    public Double getImdbRating() {
        return imdbRating;
    }

    public String[] getLanguages() {
        return languages;
    }

    public String[] getCountries() {
        return countries;
    }

    public List<Role> getActors() {
        return actors;
    }

    public void setActors(List<Role> actors) {
        this.actors = actors;
    }

    
    public List<Rating> getRatings() { return ratings; }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Genre> getGenres() { return genres; }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}