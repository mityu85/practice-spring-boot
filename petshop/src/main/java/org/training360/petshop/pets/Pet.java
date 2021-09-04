package org.training360.petshop.pets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.training360.petshop.shops.Shop;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pets")
public class Pet {

    public Pet(String name, Species species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Species species;

    private int age;

    @ManyToOne
    private Shop shop;

    public boolean hasNoShop() {
        return shop == null;
    }
}
