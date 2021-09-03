package org.training360.imdb.movies;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieDTO> getMoviesList() {
        return movieService.getMoviesList();
    }

    @GetMapping("/stars")
    public List<MovieDTO> getMovieByRate(@RequestParam Optional<Integer> rate) {
        return movieService.getMovieByRate(rate);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDTO createNewMovie(@Valid @RequestBody CreateMovieCommand command) {
        return movieService.createNewMovie(command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovieById(@PathVariable("id") Long id) {
        movieService.deleteMovieById(id);
    }
}
