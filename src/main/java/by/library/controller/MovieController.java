package by.library.controller;


import by.library.dto.MovieDto;
import by.library.model.Movie;
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
    public MovieDto create(@RequestBody MovieDto movieDto) {

        movieService.create(movieDto);

        return movieDto;
    }

    @PutMapping
    public MovieDto update(@RequestBody MovieDto movieDto){

        movieService.update(movieDto);

        return movieDto;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        movieService.delete(id);
    }
}