package org.training360.doggo.shelters;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training360.doggo.NotFoundException;
import org.training360.doggo.dogs.CreateDogCommand;
import org.training360.doggo.dogs.Dog;
import org.training360.doggo.dogs.DogRepository;
import org.training360.doggo.dogs.DogService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShelterService {

    private ModelMapper modelMapper;
    private ShelterRepository shelterRepository;
    private DogRepository dogRepository;


    public List<ShelterDTO> getSheltersList() {
        return shelterRepository.findAll().stream()
                .map(shelter -> modelMapper.map(shelter, ShelterDTO.class))
                .collect(Collectors.toList());
    }

    public ShelterDTO createNewShelter(CreateShelterCommand command) {
        return modelMapper.map(shelterRepository.save(new Shelter(
                command.getName()
        )), ShelterDTO.class);
    }

    @Transactional
    public ShelterDTO addNewDogToExistingShelter(Long id, CreateDogCommand command) {
        Shelter shelter = shelterRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        Dog dog = new Dog(
                command.getName(),
                command.getDogType(),
                command.getAge()
        );
        shelter.addDog(dog);
        return modelMapper.map(shelter, ShelterDTO.class);
    }

    @Transactional
    public ShelterDTO addExistingDogToExistingShelter(Long id, UpdateWithExistingDogCommand command) {
        Shelter shelter = shelterRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        Dog dog = dogRepository.findById(command.getDogId())
                .orElseThrow(() -> new NotFoundException(id));
        int dogTypeNumber = getDogTypeNumber(shelter, dog);
        if (dog.dogHasNoShelter() && dogTypeNumber < 2) {
            shelter.addDog(dog);
        }
        return modelMapper.map(shelter, ShelterDTO.class);
    }

    private int getDogTypeNumber(Shelter shelter, Dog dog) {
        int dogTypeCounter = 0;
        for (Dog d: shelter.getDogs()) {
            if (d.getDogType() == dog.getDogType()) {
                dogTypeCounter++;
            }
        }
        return dogTypeCounter;
    }
}
