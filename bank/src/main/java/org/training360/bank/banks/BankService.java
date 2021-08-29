package org.training360.bank.banks;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training360.bank.NotFoundException;
import org.training360.bank.accounts.Account;
import org.training360.bank.accounts.AccountRepository;
import org.training360.bank.accounts.CreateAccountCommand;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BankService {

    private ModelMapper modelMapper;
    private BankRepository bankRepository;
    private AccountRepository accountRepository;

    public List<BankDTO> getBanksList() {
        return bankRepository.findAll().stream()
                .map(bank -> modelMapper.map(bank, BankDTO.class))
                .collect(Collectors.toList());
    }

    public BankDTO createBank(CreateBankCommand command) {
        return modelMapper.map(bankRepository.save(new Bank(
                command.getName()
        )), BankDTO.class);
    }

    @Transactional
    public BankDTO addNewAccountToExistingBank(Long id, CreateAccountCommand command) {
        Bank bank = bankRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        Account account = new Account(
                command.getOwnerName()
        );
        bank.addAccount(account);
        return modelMapper.map(bank, BankDTO.class);
    }

    @Transactional
    public BankDTO addExistingAccountToExistingBank(Long id, UpdateWithExistingAccountCommand command) {
        Bank bank = bankRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        Account account = accountRepository.findById(command.getAccountId())
                .orElseThrow(() -> new NotFoundException(id));
        if (account.hasNoBank()) {
            bank.addAccount(account);
        }
        return modelMapper.map(bank, BankDTO.class);
    }
}
