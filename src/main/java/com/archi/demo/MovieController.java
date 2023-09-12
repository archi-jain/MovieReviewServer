package com.archi.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService service;

//    @GetMapping
//    public String allMovies(){
//        return "All Movies!!";
//    }

//    @GetMapping
//    public ResponseEntity<String> getAllMovies(){
//        return new ResponseEntity<String>("All Movies!!", HttpStatus.OK);
//    }

//    @GetMapping
//    public ResponseEntity<List<Movie>> getAllMovies(){
//        return new ResponseEntity<List<Movie>>(movieServices.allMovies(),HttpStatus.OK);


    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<List<Movie>>(service.findAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(service.findMovieByImdbId(imdbId), HttpStatus.OK);
    }

    }


