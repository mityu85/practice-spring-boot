package org.training360.petshop.shops;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training360.petshop.NotFoundException;
import org.training360.petshop.pets.CreatePetCommand;
import org.training360.petshop.pets.Pet;
import org.training360.petshop.pets.PetRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShopService {

    private ModelMapper modelMapper;
    private ShopRepository shopRepository;
    private PetRepository petRepository;


    public List<ShopDTO> getShopsList(Optional<String> name) {
        return shopRepository.findAll().stream()
                .filter(shop -> name.isEmpty() || shop.getName().equalsIgnoreCase(name.get()))
                .map(shop -> modelMapper.map(shop, ShopDTO.class))
                .collect(Collectors.toList());
    }

    public ShopDTO createNewShop(CreateShopCommand command) {
        return modelMapper.map(shopRepository.save(new Shop(
                command.getName()
        )), ShopDTO.class);
    }

    @Transactional
    public ShopDTO addNewPetToExistingShop(Long id, CreatePetCommand command) {
        Shop shop = shopRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        Pet pet = new Pet(
                command.getName(),
                command.getSpecies(),
                command.getAge()
        );
        shop.addPet(pet);
        return modelMapper.map(shop, ShopDTO.class);
    }

    @Transactional
    public ShopDTO addExistingPetToExistingShop(Long id, UpdateExistingShopCommand command) {
        Shop shop = shopRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        Pet pet = petRepository.findById(command.getPetId())
                .orElseThrow(() -> new NotFoundException(id));
        if (pet.hasNoShop() && isHasSpaceForSpecies(shop, pet)) {
            shop.addPet(pet);
        }
        return modelMapper.map(shop, ShopDTO.class);
    }

    private boolean isHasSpaceForSpecies(Shop shop, Pet pet) {
        boolean hasSpaceForSpecies = shop.getPets().stream()
                .filter(p -> p.getSpecies() == pet.getSpecies())
                .collect(Collectors.toList()).size() < 2;
        return hasSpaceForSpecies;
    }
}
