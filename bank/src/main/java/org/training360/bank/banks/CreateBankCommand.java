package org.training360.bank.banks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBankCommand {

    @NotBlank(message = "name cannot be blank")
    private String name;
}
