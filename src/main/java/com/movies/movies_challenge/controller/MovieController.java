package com.movies.movies_challenge.controller;

import com.movies.movies_challenge.model.Movie;
import com.movies.movies_challenge.model.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies(
            @RequestParam(required = false) Integer rank,
            @RequestParam(required = false) String date){
        try {
            if (rank != null && rank >= 0 && rank <= 10) {
                return new ResponseEntity<>(movieService.getMoviesByRank(rank), HttpStatus.OK);
            } else if (date != null) {
                return new ResponseEntity<>(movieService.getMoviesByDate(date), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(movieService.getMovies(), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie createdMovie = movieService.addMovie(movie);
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
        Movie updatedMovie = movieService.updateMovie(movie);
        if (updatedMovie != null) {
            return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{title}")
    public ResponseEntity<String> deleteMovie(@PathVariable String title) {
        movieService.deleteMovie(title);
        return new ResponseEntity<>("Movie deleted", HttpStatus.OK);
    }
}
