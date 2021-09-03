package org.training360.doggo.dogs;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dogs")
public class DogController {

    private DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public List<DogDTO> getDogsList() {
        return dogService.getDogsList();
    }

    @GetMapping("/breed")
    public List<DogDTO> findDogByBreed(@RequestParam Optional<DogType> dogType) {
        return dogService.findDogByBreed(dogType);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DogDTO createNewDog(@RequestBody CreateDogCommand command) {
        return dogService.createNewDog(command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDog(@PathVariable("id") Long id) {
        dogService.deleteDog(id);
    }
}
