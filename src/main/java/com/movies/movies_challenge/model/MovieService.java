package com.movies.movies_challenge.model;

import com.movies.movies_challenge.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> getMoviesByRank(int rank) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getRank() == rank)
                .collect(Collectors.toList());
    }

    public List<Movie> getMoviesByDate(String date) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getDate().equals(date))
                .collect(Collectors.toList());
    }

    public Movie addMovie(Movie movie) {
        movieRepository.save(movie);
        return movie;
    }

    public Movie updateMovie(Movie movie) {
        Optional<Movie> existingMovie = movieRepository.findByTitle(movie.getTitle());
        if (existingMovie.isPresent()) {
            Movie movieToUpdate = existingMovie.get();
            movieToUpdate.setTitle(movie.getTitle());
            movieToUpdate.setDate(movie.getDate());
            movieToUpdate.setRank(movie.getRank());
            movieToUpdate.setRevenue(movie.getRevenue());
            movieRepository.save(movieToUpdate);
            return movieToUpdate;
        }
        return null;
    }

    @Transactional
    public void deleteMovie(String title) {
        movieRepository.deleteByTitle(title);
    }
}
