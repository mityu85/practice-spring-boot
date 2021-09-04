package org.training360.petshop.shops;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateShopCommand {

    @NotBlank(message = "name cannot be blank")
    private String name;
}
