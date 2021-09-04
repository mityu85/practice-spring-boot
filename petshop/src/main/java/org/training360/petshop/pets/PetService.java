package org.training360.petshop.pets;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.awt.desktop.OpenFilesEvent;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PetService {

    private ModelMapper modelMapper;
    private PetRepository petRepository;


    public List<PetDTO> getPetsList(Optional<String> name) {
        return petRepository.findAll().stream()
                .filter(pet -> name.isEmpty() || pet.getName().equalsIgnoreCase(name.get()))
                .map(pet -> modelMapper.map(pet, PetDTO.class))
                .collect(Collectors.toList());
    }

    public PetDTO createNewPet(CreatePetCommand command) {
        return modelMapper.map(petRepository.save(new Pet(
                command.getName(),
                command.getSpecies(),
                command.getAge()
        )), PetDTO.class);
    }

    public void deletePetById(Long id) {
        petRepository.deleteById(id);
    }
}
