package org.training360.imdb.categories;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.training360.imdb.movies.CreateMovieCommand;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryDTO> getCategoriesList() {
        return categoryService.getCategoriesList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDTO createNewCategory(@Valid @RequestBody CreateCategoryCommand command) {
        return categoryService.createNewCategory(command);
    }

    @PostMapping("/{id}/movies")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDTO addNewMovieToExistingCategory(@PathVariable("id") Long id, @Valid @RequestBody CreateMovieCommand command) {
        return categoryService.addNewMovieToExistingCategory(id, command);
    }

    @PutMapping("/{id}/movies")
    public CategoryDTO addExistingMovieToExistingCategory(@PathVariable("id") Long id, @RequestBody UpdateCategoryCommand command) {
        return categoryService.addExistingMovieToExistingCategory(id, command);
    }
}
