package org.training360.bank.accounts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.training360.bank.banks.Bank;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {

    public Account(String ownerName) {
        this.ownerName = ownerName;
        Random random = new Random();
        this.accountNumber = String.valueOf(random.nextInt(99999999)+10000000);
        this.creationDate = LocalDateTime.now();
        balance = 0L;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "account_number")
    private String accountNumber;

    private Long balance;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @ManyToOne
    private Bank bank;

    public boolean hasNoBank() {
        return bank == null;
    }
}
