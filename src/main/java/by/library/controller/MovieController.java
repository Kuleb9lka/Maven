package by.library.controller;


import by.library.dto.MovieDto;
import by.library.model.movie.Movie;
import by.library.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAll(){

        return movieService.getAll();
    }

    @GetMapping("/{id}")
    public Movie get(@PathVariable Long id){

        return movieService.get(id);
    }


    @PostMapping
    public Movie create(@RequestBody MovieDto movie) {

        return movieService.create(movie);
    }

    @PutMapping
    public Movie update(@RequestBody MovieDto movie){

        return movieService.update(movie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        movieService.delete(id);
    }
}