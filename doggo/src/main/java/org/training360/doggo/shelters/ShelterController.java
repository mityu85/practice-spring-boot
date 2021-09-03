package org.training360.doggo.shelters;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.training360.doggo.dogs.CreateDogCommand;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/shelters")
public class ShelterController {

    private ShelterService shelterService;

    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    @GetMapping
    public List<ShelterDTO> getSheltersList() {
        return shelterService.getSheltersList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShelterDTO createNewShelter(@Valid @RequestBody CreateShelterCommand command) {
        return shelterService.createNewShelter(command);
    }

    @PostMapping("/{id}/dogs")
    @ResponseStatus(HttpStatus.CREATED)
    public ShelterDTO addNewDogToExistingShelter(@PathVariable("id") Long id, @Valid @RequestBody CreateDogCommand command) {
        return shelterService.addNewDogToExistingShelter(id, command);
    }

    @PutMapping("/{id}/dogs")
    public ShelterDTO addExistingDogToExistingShelter(@PathVariable("id") Long id, @RequestBody UpdateWithExistingDogCommand command) {
        return shelterService.addExistingDogToExistingShelter(id, command);
    }
}
