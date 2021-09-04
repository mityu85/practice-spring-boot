package org.training360.petshop.pets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePetCommand {

    @NotBlank(message = "name cannot be blank")
    private String name;
    private Species species;
    private int age;
}
