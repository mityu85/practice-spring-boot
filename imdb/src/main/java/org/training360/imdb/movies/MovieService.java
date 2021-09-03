package org.training360.imdb.movies;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieService {

    private ModelMapper modelMapper;
    private MovieRepository movieRepository;

    public List<MovieDTO> getMoviesList() {
        return movieRepository.findAll().stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class))
                .collect(Collectors.toList());
    }

    public List<MovieDTO> getMovieByRate(Optional<Integer> rate) {
        return movieRepository.findAll().stream()
                .filter(movie -> rate.isEmpty() || movie.getRate() == rate.get())
                .map(movie -> modelMapper.map(movie, MovieDTO.class))
                .collect(Collectors.toList());
    }

    public MovieDTO createNewMovie(CreateMovieCommand command) {
        return modelMapper.map(movieRepository.save(new Movie(
                command.getTitle(),
                command.getRate()
        )), MovieDTO.class);
    }

    public void deleteMovieById(Long id) {
        movieRepository.deleteById(id);
    }
}
