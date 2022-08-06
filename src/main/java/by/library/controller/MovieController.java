package by.library.controller;


import by.library.dto.admin.MovieDtoForAdmin;
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
    public List<MovieDtoForAdmin> getAll(){

        return movieService.getAll();
    }

    @GetMapping("/{id}")
    public MovieDtoForAdmin get(@PathVariable Long id){

        return movieService.get(id);
    }

    @PostMapping
    public MovieDtoForAdmin create(@RequestBody MovieDtoForAdmin movieDto) {

        return movieService.create(movieDto);
    }

    @PutMapping
    public MovieDtoForAdmin update(@RequestBody MovieDtoForAdmin movieDto){

        return movieService.update(movieDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        movieService.delete(id);
    }
}