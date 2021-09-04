package org.training360.petshop.shops;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.training360.petshop.pets.CreatePetCommand;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shops")
public class ShopController {

    private ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public List<ShopDTO> getShopsList(Optional<String> name) {
        return shopService.getShopsList(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShopDTO createNewShop(@Valid @RequestBody CreateShopCommand command) {
        return shopService.createNewShop(command);
    }

    @PostMapping("/{id}/pets")
    @ResponseStatus(HttpStatus.CREATED)
    public ShopDTO addNewPetToExistingShop(@PathVariable("id") Long id, @Valid @RequestBody CreatePetCommand command) {
        return shopService.addNewPetToExistingShop(id, command);
    }

    @PutMapping("/{id}/pets")
    public ShopDTO addExistingPetToExistingShop(@PathVariable("id") Long id, @RequestBody UpdateExistingShopCommand command) {
        return shopService.addExistingPetToExistingShop(id, command);
    }

}
