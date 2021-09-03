package org.training360.doggo.dogs;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DogService {

    private ModelMapper modelMapper;
    private DogRepository dogRepository;


    public List<DogDTO> getDogsList() {
        return dogRepository.findAll().stream()
                .map(dog -> modelMapper.map(dog, DogDTO.class))
                .collect(Collectors.toList());
    }

    public DogDTO createNewDog(CreateDogCommand command) {
        return modelMapper.map(dogRepository.save(new Dog(
                command.getName(),
                command.getDogType(),
                command.getAge()
        )), DogDTO.class);
    }

    public void deleteDog(Long id) {
        dogRepository.deleteById(id);
    }

    public List<DogDTO> findDogByBreed(Optional<DogType> dogType) {
        return dogRepository.findAll().stream()
                .filter(dog -> dogType.isEmpty() || dog.getDogType() == dogType.get())
                .map(dog -> modelMapper.map(dog, DogDTO.class))
                .collect(Collectors.toList());
    }
}
