package by.library.controller;


import by.library.model.movie.Movie;
import by.library.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
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

    @GetMapping("/get/{id}")
    public Movie get(@PathVariable Long id){

        return movieService.get(id);
    }

    @GetMapping("/create/{name}/{date}")
    public Movie create(@PathVariable String name, @PathVariable Timestamp date) {

        Movie movie = new Movie(name, date);

        return movieService.create(movie);
    }

    @GetMapping("/update/{id}/{name}/{date}")
    public Movie update(@PathVariable Long id, @PathVariable String name, @PathVariable Timestamp date){

        Movie movie = movieService.get(id);

        movie.setName(name);

        movie.setDate(date);

        return movieService.update(movie);
    }

    @GetMapping("/delete/{id}")
    public Movie delete(@PathVariable Long id){

        Movie movie = movieService.get(id);

        return movieService.delete(movie);
    }
}