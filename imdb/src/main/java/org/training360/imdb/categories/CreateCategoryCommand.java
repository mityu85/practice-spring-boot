package org.training360.imdb.categories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryCommand {

    @NotBlank(message = "name cannot be blank")
    private String name;
}
