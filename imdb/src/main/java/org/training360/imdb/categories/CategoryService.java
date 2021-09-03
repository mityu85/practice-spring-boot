package org.training360.imdb.categories;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training360.imdb.NotFoundException;
import org.training360.imdb.movies.CreateMovieCommand;
import org.training360.imdb.movies.Movie;
import org.training360.imdb.movies.MovieRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryService {

    private ModelMapper modelMapper;
    private CategoryRepository categoryRepository;
    private MovieRepository movieRepository;


    public List<CategoryDTO> getCategoriesList() {
        return categoryRepository.findAll().stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    public CategoryDTO createNewCategory(CreateCategoryCommand command) {
        return modelMapper.map(categoryRepository.save(new Category(
                command.getName()
        )), CategoryDTO.class);
    }

    @Transactional
    public CategoryDTO addNewMovieToExistingCategory(Long id, CreateMovieCommand command) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        Movie movie = new Movie(
                command.getTitle(),
                command.getRate()
        );
        category.addMovie(movie);
        return modelMapper.map(category, CategoryDTO.class);
    }

    @Transactional
    public CategoryDTO addExistingMovieToExistingCategory(Long id, UpdateCategoryCommand command) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        Movie movie = movieRepository.findById(command.getMovieId())
                .orElseThrow(() -> new NotFoundException(id));
        if (movie.hasNoCategory()) {
            category.addMovie(movie);
        }
        return modelMapper.map(category, CategoryDTO.class);
    }
}
