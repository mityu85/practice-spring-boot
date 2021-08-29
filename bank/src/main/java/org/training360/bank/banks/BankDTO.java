package org.training360.bank.banks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.training360.bank.accounts.Account;
import org.training360.bank.accounts.AccountDTO;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankDTO {

    private Long id;
    private String name;
    private List<AccountDTO> accounts = new ArrayList<>();
}
