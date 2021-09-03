package org.training360.doggo.dogs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateDogCommand {

    private String name;
    private DogType dogType;
    private int age;
}
