package org.training360.petshop.pets;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public List<PetDTO> getPetsList(Optional<String> name) {
        return petService.getPetsList(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PetDTO createNewPet(@Valid @RequestBody CreatePetCommand command) {
        return petService.createNewPet(command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePetById(@PathVariable("id") Long id) {
        petService.deletePetById(id);
    }
}
