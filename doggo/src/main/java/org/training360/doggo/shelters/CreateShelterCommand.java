package org.training360.doggo.shelters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateShelterCommand {

    @NotBlank(message = "name cannot be blank")
    private String name;
}
