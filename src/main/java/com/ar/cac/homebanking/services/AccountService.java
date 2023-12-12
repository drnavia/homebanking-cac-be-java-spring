package com.ar.cac.homebanking.services;

import com.ar.cac.homebanking.exceptions.AccountNotExistsException;
import com.ar.cac.homebanking.mappers.AccountMapper;
import com.ar.cac.homebanking.mappers.UserMapper;
import com.ar.cac.homebanking.models.Account;
import com.ar.cac.homebanking.models.User;
import com.ar.cac.homebanking.models.dtos.AccountDTO;
import com.ar.cac.homebanking.models.dtos.UserDTO;
import com.ar.cac.homebanking.models.enums.AccountType;
import com.ar.cac.homebanking.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
    /*
     * Inyectar una instancia del Repositorio
     */
    @Autowired
    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public List<AccountDTO> getAccounts() {
        List<Account> accounts = repository.findAll();
        return accounts.stream()
                .map(AccountMapper::accountToDto)
                .collect(Collectors.toList());
    }

    public AccountDTO getAccountById(Long id) {
        Account entity = repository.findById(id).get();
        return AccountMapper.accountToDto(entity);
    }

    public AccountDTO createAccount(AccountDTO accountDto) {
        accountDto.setType(AccountType.CURRENT_ACCOUNT);
        accountDto.setAmount(BigDecimal.ZERO);
        Account accountSaved = repository.save(AccountMapper.dtoToAccount(accountDto));
        return AccountMapper.accountToDto(accountSaved);
    }

    public AccountDTO updateAccount(Long id, AccountDTO dto) {
        if (repository.existsById(id)) {
            Account accountToModify = repository.findById(id).get();

            // Validar qué datos no vienen en null para setearlos al objeto ya creado.
            // Lógica del Patch
            if (dto.getAlias() != null) {
                accountToModify.setAlias(dto.getAlias());
            }
            if (dto.getType() != null) {
                accountToModify.setType(dto.getType());
            }
            if (dto.getCbu() != null) {
                accountToModify.setCbu(dto.getCbu());
            }
            if (dto.getAmount() != null) {
                accountToModify.setAmount(dto.getAmount());
            }
            Account accountModified = repository.save(accountToModify);
            return AccountMapper.accountToDto(accountModified);
        }
        return null;
    }

    public String deleteAccount(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "La cuenta con id: " + id + " ha sido eliminada";
        } else {
            throw new AccountNotExistsException("La cuenta a eliminar no existe");
        }
    }
}
