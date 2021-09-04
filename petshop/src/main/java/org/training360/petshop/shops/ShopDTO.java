package org.training360.petshop.shops;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.training360.petshop.pets.Pet;
import org.training360.petshop.pets.PetDTO;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopDTO {

    private Long id;
    private String name;
    private List<PetDTO> pets;
}
