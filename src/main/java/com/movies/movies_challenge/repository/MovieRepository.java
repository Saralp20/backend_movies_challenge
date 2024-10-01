package com.movies.movies_challenge.repository;

import com.movies.movies_challenge.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {

    void deleteByTitle(String title);

    Optional<Movie> findByTitle(String title);
}
