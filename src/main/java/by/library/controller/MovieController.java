package by.library.controller;


import by.library.dto.admin.AdminMovieDto;
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
    public List<AdminMovieDto> getAll(){

        return movieService.getAll();
    }

    @GetMapping("/{id}")
    public AdminMovieDto get(@PathVariable Long id){

        return movieService.get(id);
    }

    @PostMapping
    public AdminMovieDto create(@RequestBody AdminMovieDto movieDto) {

        return movieService.create(movieDto);
    }

    @PutMapping
    public AdminMovieDto update(@RequestBody AdminMovieDto movieDto){

        return movieService.update(movieDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        movieService.delete(id);
    }
}