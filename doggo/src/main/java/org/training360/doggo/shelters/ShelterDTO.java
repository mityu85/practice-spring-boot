package org.training360.doggo.shelters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.training360.doggo.dogs.DogDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShelterDTO {

    private Long id;
    private String name;
    private List<DogDTO> dogs;
}
