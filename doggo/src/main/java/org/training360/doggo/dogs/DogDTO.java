package org.training360.doggo.dogs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DogDTO {

    private Long id;
    private String name;
    private DogType dogType;
    private int age;
}
