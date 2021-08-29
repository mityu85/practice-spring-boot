package org.training360.bank.accounts;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountService {

    private ModelMapper modelMapper;
    private AccountRepository accountRepository;

    public List<AccountDTO> getAccountsList() {
        return accountRepository.findAll().stream()
                .map(account -> modelMapper.map(account, AccountDTO.class))
                .collect(Collectors.toList());
    }

    public AccountDTO createAccount(CreateAccountCommand command) {
        return modelMapper.map(accountRepository.save(new Account(
                command.getOwnerName()
        )), AccountDTO.class);
    }

    public void deleteAccountById(Long id) {
        accountRepository.deleteById(id);
    }
}
