package org.training360.doggo.dogs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.training360.doggo.shelters.Shelter;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dogs")
public class Dog {

    public Dog(String name, DogType dogType, int age) {
        this.name = name;
        this.dogType = dogType;
        this.age = age;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "breed")
    private DogType dogType;

    private int age;

    @ManyToOne
    private Shelter shelter;

    public boolean dogHasNoShelter() {
        return shelter == null;
    }
}
