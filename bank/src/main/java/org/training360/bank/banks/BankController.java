package org.training360.bank.banks;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.training360.bank.accounts.CreateAccountCommand;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/banks")
public class BankController {

    private BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping
    public List<BankDTO> getBanksList() {
        return bankService.getBanksList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BankDTO createBank(@Valid @RequestBody CreateBankCommand command) {
        return bankService.createBank(command);
    }

    @PostMapping("/{id}/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public BankDTO addNewAccountToExistingBank(@PathVariable("id") Long id, @RequestBody CreateAccountCommand command) {
        return bankService.addNewAccountToExistingBank(id, command);
    }

    @PutMapping("/{id}/accounts")
    public BankDTO addExistingAccountToExistingBank(@PathVariable("id") Long id, @RequestBody UpdateWithExistingAccountCommand command) {
        return bankService.addExistingAccountToExistingBank(id, command);
    }
}
