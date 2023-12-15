package com.ar.cac.homebanking.mappers;

import com.ar.cac.homebanking.models.Account;
import com.ar.cac.homebanking.models.dtos.AccountDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountMapper {

    // TODO: REFACTOR BUILDER
    public Account dtoToAccount(AccountDTO dto) {
        Account account = new Account();
        account.setType(dto.getType());
        account.setCbu(dto.getCbu());
        account.setAlias(dto.getAlias());
        account.setAmount(dto.getAmount());
        account.setOwner(dto.getOwner());

        return account;
    }

    public AccountDTO accountToDto(Account account) {
        AccountDTO dto = new AccountDTO();
        dto.setId(account.getId());
        dto.setType(account.getType());
        dto.setCbu(account.getCbu());
        dto.setAlias(account.getAlias());
        dto.setAmount(account.getAmount());
        dto.setOwner(account.getOwner());

        return dto;
    }
}
