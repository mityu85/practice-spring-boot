package org.training360.imdb.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMovieCommand {

    @NotBlank(message = "title cannot be blank")
    private String title;
    private int rate;
}
