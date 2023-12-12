package com.ar.cac.homebanking.controllers;

import com.ar.cac.homebanking.models.Account;
import com.ar.cac.homebanking.models.dtos.AccountDTO;
import com.ar.cac.homebanking.models.dtos.UserDTO;
import com.ar.cac.homebanking.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// ANOTACIONES
@RestController
@RequestMapping("/api/accounts")
// CLASE
public class AccountController {
    /*
     * Generar una instancia del Service (UserService) -> Inyectar una instancia mediante Spring Boot
     */
    @Autowired
    private final AccountService service;
    // Constructor
    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AccountDTO>> getUsers() {

        List<AccountDTO> lista = service.getAccounts();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAccountById(id));
    }

    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createAccount(dto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AccountDTO> updateAllAccount(@PathVariable Long id, @RequestBody AccountDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateAccount(id, dto));
    }

    // TODO: Refactor en Exception
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteAccount(id));
    }

}
